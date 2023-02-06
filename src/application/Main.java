package application;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;


import com.chat.domain.Message;
import com.chat.domain.UsersLocal;
import com.chat.gui.DiseñoDerecho;
import com.chat.gui.DiseñoIzquierdo;
import com.chat.gui.ImagesUsers;
import com.chat.gui.PanelesScroll;
import com.chat.gui.Users;
import com.chat.gui.WinChat;
import com.chat.gui.WinLogin;
import com.chat.repositorio.ChatRepository;
import com.chat.repositorio.RepositoryMessages;
import com.chat.repositorio.UserRepository;
import com.chat.util.MessageArrivedAction;
import com.chat.util.MqttChat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	MqttChat chat = new MqttChat();
	UserRepository reposiuser = new UserRepository();
	RepositoryMessages reposiMessage = new RepositoryMessages();
	ChatRepository reposichat= new ChatRepository();

	ImagesUsers contentImag = new ImagesUsers();
	
	
	WinChat winchat = new WinChat();
	Users listadoUser = new Users();
	Button btnSalir = new Button("Sign Out");
	
	Stage escenario2 = new Stage();
	static DiseñoIzquierdo contenido;
	List<DiseñoIzquierdo> lista= new ArrayList<DiseñoIzquierdo>();
	
	@Override
	public void start(Stage escenario) throws Exception {
		
		
//VENTANA DE LOGIN	
		WinLogin winlog = new WinLogin();
		winlog.userText();
		winlog.clavePass();
		winlog.loginButton();
		winlog.tituloLabel();
		
//VENTANA DE CHAT Y PERFIL DE USUARIO	
		winlog.getLogin().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				escenario.close();
				
				String  usuariostr = new String(""+winlog.getUser().getText());
				String pastr = new String(""+winlog.getClave().getText());
				
				if ( reposiuser.login( usuariostr, pastr)== null) { 
					System.out.println("Usuario no encontrado "+ winlog.getUser().getText() +"  " +winlog.getClave().getText());
					escenario2.close();
					escenario.show();
					
				}
				
				else {
// el metodo justconnect se conecta una sola vez al servidor y retorna un statement listo para recibir y ejecutar querys
				
					
					UsersLocal userlog = reposiuser.login(usuariostr, pastr);
					
					PanelesScroll panels = new PanelesScroll();
					VBox contenidoIzq = new VBox(2);
					FlowPane contenidoDer = new FlowPane();
					winchat.chat();
					winchat.enviar();
					winchat.usuarioId(winlog.getUser().getText());
					listadoUser.listaUsuarios();
					panels.panelIzq(contenidoIzq);
					panels.panelDerecho(contenidoDer);
				
				 
//PARTE SUPERIOR IZQUIERDA
					HBox panelSupIzq = new HBox(15, listadoUser.validacion(winlog.getUser().getText()), winchat.getUsuarioId(), btnSalir);
					panelSupIzq.setPadding(new Insets(5, 0, 0, 10));
					panelSupIzq.setAlignment(Pos.CENTER);
				
//PARTE SUPERIOR DERECHA
					HBox panelSupDer = new HBox(15);
					panelSupDer.setPadding(new Insets(5, 0, 0, 10));
					panelSupDer.setAlignment(Pos.CENTER);
				
//CONTENIDO IZQUIERDO
//					
						for(int i = 0; i < reposichat.getContactos(userlog.getId()).size() ; i++){
						 contenido = new DiseñoIzquierdo();
						contenido.contenidoMsj(reposichat.getContactos(userlog.getId()).get(i).getUltimoMsj().getContent(),
								reposichat.getContactos(userlog.getId()).get(i).getContactos().getUsername(),
								reposichat.getContactos(userlog.getId()).get(i).getUltimoMsj().getDate(), 
								reposichat.getContactos(userlog.getId()).get(i).getContactos().getId(), 30);
						
						contenidoIzq.getChildren().addAll(contenido.getContenido());
						contenidoIzq.getChildren().get(i).setId(reposichat.getContactos(userlog.getId()).get(i).getContactos().getId()+"");
						lista.add(contenido);

				}
				
//CONTENIDO DERECHO
					for(int i=0; i<contenidoIzq.getChildren().size();i++) {
						int j=i;
						contenidoIzq.getChildren().get(j).addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {
								//aquí también usé el userlog en lugar de reposiuser
								List<Message> resultado= reposiMessage.getMensajes(userlog.getId(), Integer.valueOf(contenidoIzq.getChildren().get(j).getId()));
								contenidoDer.getChildren().clear();
								
								for(Message contenido: resultado) {
									DiseñoDerecho contenido1 = new DiseñoDerecho();
									if(contenido.getFrom().getId()== Integer.valueOf(contenidoIzq.getChildren().get(j).getId())&& 
											contenido.getTo().getId() == userlog.getId()) {
										
										contenido1.contenidoMsj(contenido.getContent(), contenido.getDate(),"rgb(40,152,238)" , Pos.TOP_LEFT, reposichat.getContactos(
												userlog.getId()).get(j).getContactos().getId(), 30, true);
										contenidoDer.getChildren().add(contenido1.getContenido());
										try {
										//aquí no supe si cambiarlo o no porque sale error
											chat.connect(reposiuser.getByUserName(winlog.getUser().getText()));
											chat.subscribe(winlog.getUser().getText());
											chat.messageArrived(new MessageArrivedAction() {
												
												@Override
												public void messageArrived(String topic, Message message) {
													Platform.runLater(new Runnable() {

														@Override
														public void run() {
															if(contenidoIzq.getChildren().get(j).getId().equals(message.getFrom().getId()+"")) {
																DiseñoDerecho contenido1 = new DiseñoDerecho();
																contenido1.contenidoMsj(message.getContent(), message.getDate(), "rgb(40,152,238)", 
																		Pos.TOP_LEFT, message.getFrom().getId(), 30, true);
																
																contenidoDer.getChildren().add(contenido1.getContenido());
																reposiMessage.addsms(new Message(reposiMessage.getlastsms(userlog.getId(), Integer.valueOf(contenidoIzq.getChildren().get(j).getId())).getId()+1,
																		message.getFrom(), message.getTo(), message.getContent(), message.getDate()));
																panels.ajusteDesplDer(contenidoDer);
																//clean and add list up
																	lista.get(j).getUltimoMsj().setText(message.getContent());
																
																
																//clean and add list up
																System.out.println(reposiMessage.getMensajes(message.getTo().getId(), message.getFrom().getId()).size());
																escenario2.close();
																escenario2.show();
															}
															
															
															
														}
														
													});
													
												}
											});
										}
										catch (MqttException e) {

                                            e.printStackTrace();
                                        }
										
									}
									// aqui usamos userlog
									else if(contenido.getFrom().getId()== userlog.getId()&& contenido.getTo().getId()== 
											reposichat.getContactos(userlog.getId()).get(j).getContactos().getId()) {
		
										
										//EVENTO ENVIAR	MENSAJES PULSANDO EL BOTON 		
										winchat.getEnviar().setOnAction(new EventHandler<ActionEvent>() {
											
											@Override
											public void handle(ActionEvent event) {
												
												DiseñoDerecho enviado = new DiseñoDerecho();
												if(!winchat.getChat().getText().equals("")) {
													try {
														LocalDateTime hours = LocalDateTime.now();
														//aquí usamos userlog
														
														//Ref:Mostra Ultimo Mensaje -> Desc. Se Agrega el ultimo mensaje a la lista quemada en RepositoryMessages addsms2
														//Parms: menssage -> getFrom -> getTo -> menssage -> hours
														String menssage = (String) winchat.getChat().getText();

														reposiMessage.addsms2(contenido.getFrom(),contenido.getTo(), menssage, hours);
														//Ref:Mostra Ultimo Mensaje -> Desc. Se Agrega el ultimo mensaje a la lista quemada en RepositoryMessages addsms2
														
														chat.sendMessage(reposichat.getContactos(userlog.getId()).get(j).getContactos().getUsername(),
																//winchat.getChat().getText().toString());
																reposiMessage.getlastsms(contenido.getFrom().getId(), contenido.getTo().getId()));
														//aquí también userlog
														enviado.contenidoMsj(winchat.getChat().getText(), hours, "rgb(60,76,143)", Pos.TOP_RIGHT, 
																userlog.getId(), 30, false);
					
														contenidoDer.getChildren().add(enviado.getContenido());
														panels.ajusteDesplDer(contenidoDer);
														//clean and add list up
															lista.get(j).getUltimoMsj().setText(winchat.getChat().getText());
															lista.get(j).getHours().setText(hours+"");
														winchat.getChat().clear();
														escenario2.close();
														escenario2.show();
														
														
														
													}
													catch (MqttPersistenceException e1) {
                                                        e1.printStackTrace();

                                                    }

                                                    catch (MqttException e1) {
                                                        e1.printStackTrace();
                                                    }
												}
											}
										});
										//usando el enter (enviamos)
										
										winchat.getChat().setOnKeyPressed(new EventHandler<KeyEvent>() {
											
											@Override
											public void handle(KeyEvent event) {
												if(event.getCode() == KeyCode.ENTER) {
													
													DiseñoDerecho enviado = new DiseñoDerecho();
													if(!winchat.getChat().getText().equals("")) {
														try {
															LocalDateTime hours = LocalDateTime.now();
															
															
															//Ref:Mostra Ultimo Mensaje -> Desc. Se Agrega el ultimo mensaje a la lista quemada en RepositoryMessages addsms2
															//Parms: menssage -> getFrom -> getTo -> menssage -> hours
															String menssage = (String) winchat.getChat().getText();
//															
															reposiMessage.addsms2(contenido.getFrom(),contenido.getTo(), menssage, hours);
															//Ref:Mostra Ultimo Mensaje -> Desc. Se Agrega el ultimo mensaje a la lista quemada en RepositoryMessages addsms2
//															^^^ this method was replace
															
															
															//aquí usamos userlog
															chat.sendMessage(reposichat.getContactos(userlog.getId()).get(j).getContactos().getUsername(),
																	reposiMessage.getlastsms(contenido.getFrom().getId(), contenido.getTo().getId()));
															//aquí también userlog
															enviado.contenidoMsj(winchat.getChat().getText(), hours, "rgb(60,76,143)", Pos.TOP_RIGHT, 
																	userlog.getId(), 30, false);
															
															contenidoDer.getChildren().add(enviado.getContenido());
															panels.ajusteDesplDer(contenidoDer);
															//clean and add list up
															
																lista.get(j).getUltimoMsj().setText(winchat.getChat().getText());
																lista.get(j).getHours().setText(hours+"");

															winchat.getChat().clear();
															escenario2.close();
															escenario2.show();
														}
														catch (MqttPersistenceException e1) {
					                                        e1.printStackTrace();

					                                    }

					                                    catch (MqttException e1) {
					                                        e1.printStackTrace();
					                                    }
													}
													/////////
													
												}
											}
										});
										
										
										
										
										
										// aqui usamos el user log
										contenido1.contenidoMsj(contenido.getContent(), contenido.getDate(), "rgb(60,76,143)", Pos.TOP_RIGHT, userlog.getId(), 30, false);
										contenidoDer.getChildren().add(contenido1.getContenido());
										panels.ajusteDesplDer(contenidoDer);
										
										
										
									}
									
									winchat.contactos(reposichat.getContactos(userlog.getId()).get(j).getContactos().getUsername());
									Label disp = new Label(listadoUser.getDisponibilidad().get(j+1));
									disp.setStyle("-fx-text-fill: white");
									GridPane pSd = new GridPane();
//									
									pSd.add(winchat.getContactos(), 0, 0);
									pSd.add(disp, 0, 1);
									pSd.setVgap(5);
									pSd.setHgap(10);
									
									panelSupDer.getChildren().clear();				
									panelSupDer.getChildren().addAll(listadoUser.validacion(reposichat.getContactos(userlog.getId()).get(j).getContactos().getUsername()), pSd);
									
								}
								
							}
							
						
						});
					}
						
	//PANEL SCROLL				
					
//	//MODULO INFERIOR DERECHO				
					HBox chatbox = new HBox(10);
					chatbox.getChildren().addAll(winchat.getChat(), winchat.getEnviar());
					chatbox.setAlignment(Pos.CENTER);
					
	//ANCHOR PANE
					AnchorPane panel = new AnchorPane();
					panel.getChildren().addAll(panelSupIzq, panelSupDer, chatbox, panels.getPanelIzq(), panels.getPanelDer());
					panel.setStyle("-fx-background-color: rgb(8,35,56)");
					
					AnchorPane.setTopAnchor(panelSupIzq, 0d);
					AnchorPane.setTopAnchor(panelSupDer, 0d);
					AnchorPane.setLeftAnchor(panelSupDer, 350d);
					AnchorPane.setBottomAnchor(chatbox, 5d);
					AnchorPane.setRightAnchor(chatbox, 5d);
					AnchorPane.setLeftAnchor(panels.getPanelIzq(), 0d);
					AnchorPane.setTopAnchor(panels.getPanelIzq(), 50d);
					AnchorPane.setBottomAnchor(panels.getPanelIzq(), 0d);
					AnchorPane.setRightAnchor(panels.getPanelDer(), 10d);
					AnchorPane.setTopAnchor(panels.getPanelDer(), 50d);
					AnchorPane.setBottomAnchor(panels.getPanelDer(), 50d);
					
					
					Scene escena2 = new Scene(panel, 1050, 650);
					escenario2.getIcons().add(new Image("C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\msg.png"));
					escenario2.setTitle("Discord");
					escenario2.setResizable(false);
					escenario2.setScene(escena2);
					escenario2.show();
					
					//Boton salir
					btnSalir.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							System.out.println("Disconnected");
							escenario2.close();
							escenario.show();
						
						
						}
					});

				}//el else of login
				
				
				
			}
				
		});
		
		Image imagen = new Image("file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\user.png");
		ImageView img = new ImageView(imagen);
		img.setFitWidth(195);
		img.setFitHeight(195);
		img.setPreserveRatio(true);
		img.setSmooth(true);
		
		Image fondo = new Image("file:C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\fondogral.jpg");
		ImageView fond = new ImageView(fondo);
		
		VBox izq = new VBox(15, winlog.getUser(), winlog.getClave(), winlog.getLogin());
		
		VBox der = new VBox(15, winlog.getTitulo());
		der.setAlignment(Pos.CENTER);
		
		AnchorPane raiz = new AnchorPane();
		raiz.getChildren().addAll(fond, izq, der, img);
		AnchorPane.setTopAnchor(fond, 0d);
		AnchorPane.setBottomAnchor(fond, 0d);
		AnchorPane.setLeftAnchor(izq, 20d);
		AnchorPane.setTopAnchor(izq, 130d);
		AnchorPane.setTopAnchor(der, 20d);
		AnchorPane.setLeftAnchor(der, 20d);
		AnchorPane.setRightAnchor(der, 20d);
		AnchorPane.setRightAnchor(img, 20d);
		AnchorPane.setBottomAnchor(img, 60d);		
		
		Scene escena = new Scene(raiz, 450, 430);
		escenario.getIcons().add(new Image("C:\\Users\\User\\OneDrive\\Universidad\\CI 2022-2023\\PAG\\Discord\\src\\com\\chat\\image\\msg.png"));
		escenario.setTitle("Discord Penguin");
		escenario.setScene(escena);
		escenario.show();
		
		
	}

		
	
	public static void main(String[]args) {
		launch(args);
	}
	
	
			}
