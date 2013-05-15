/*
 * Copyright Synthetos LLC
 * Rileyporter@gmail.com
 * www.synthetos.com
 * 
 */
package tgfx;

import tgfx.tinyg.TinygDriver;
import java.io.File;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;


import tgfx.external.SocketMonitor;
import tgfx.render.Draw2d;
import tgfx.system.Axis;
import tgfx.system.Motor;
import org.apache.log4j.Logger;

import org.apache.log4j.BasicConfigurator;
import java.util.MissingResourceException;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.util.StringConverter;
import jfxtras.labs.scene.control.gauge.Lcd;
import jfxtras.labs.scene.control.gauge.LcdBuilder;
import jfxtras.labs.scene.control.gauge.StyleModel;
import org.apache.log4j.Level;
import tgfx.gcode.GcodeHistory;
import tgfx.system.StatusCode;
import tgfx.tinyg.CommandManager;


import javafx.stage.Stage;
import tgfx.ui.MachineSettingsController;
import tgfx.ui.TinyGConfigController;

public class Main extends Stage implements Initializable, Observer {

    static final Logger logger = Logger.getLogger(Main.class);
    private TinygDriver tg = TinygDriver.getInstance();
    private String PROMPT = "tinyg>";
    private GcodeHistory gcodeCommandHistory = new GcodeHistory();
    final static ResourceBundle rb = ResourceBundle.getBundle("version");   //Used to track build date and build number
    
    /*
     * LCD DRO PROFILE CREATION
     */
//    private Pane cncMachine = new Pane();
    /**
     * JFXtras stuff
     */
    /**
     * FXML UI Components
     */
//    Window gcodeWindow;
    @FXML
    private TabPane topTabPane;
    @FXML
    private AnchorPane topAnchorPane;
    @FXML
    private Circle cursor;
    @FXML
    private Button settingDrawBtn, Connect;
    @FXML
    TextField input, listenerPort;
    @FXML
    private Label srMomo, srState, srBuild, srBuffer, srGcodeLine, xposT, yposT,
            srVer, srUnits, srCoord, tgfxBuildNumber, tgfxBuildDate, tgfxVersion;
    @FXML
    StackPane cursorPoint;
    @FXML
    TextArea gcodesList;
    @FXML
    private static TextArea console;
    @FXML
    WebView html, makerCam;
    @FXML
    Text heightSize, widthSize;
    @FXML
    ChoiceBox serialPorts;
    //##########Config FXML##############//
    
    
    @FXML
    Group motor1Node;
    @FXML
    HBox bottom, xposhbox, gcodeWindowButtonBar, gcodePreviewHbox;
    @FXML
    HBox canvasHolder;
    @FXML
    VBox topvbox, positionsVbox, tester;
    @FXML
    ContextMenu xAxisContextMenu;

    public void testMessage(String message) {
        System.out.println("Message Hit");

    }

  public Main(){
      
  }
    @FXML
    private void handleTogglePreview(ActionEvent event) {
//        if (settingDrawBtn.getText().equals("ON")) {
//            settingDrawBtn.setText("OFF");
//            drawPreview = true;
//        } else {
//            settingDrawBtn.setText("ON");
//            drawPreview = false;
//        }
    }

    @FXML
    void handleRemoteListener(ActionEvent evt) {
//        if (tg.isConnected()) {
//            tgfx.Main.postConsoleMessage("[+]Remote Monitor Listening for Connections....");
//            Task SocketListner = this.initRemoteServer(listenerPort.getText());
//
//            new Thread(SocketListner).start();
//            btnRemoteListener.setDisable(true);
//        } else {
//            System.out.println("[!] Must be connected to TinyG First.");
//            tgfx.Main.postConsoleMessage("[!] Must be connected to TinyG First.");
//        }
    }

    @FXML
    void handleMouseScroll(ScrollEvent evt) {
//        if (evt.getDeltaX() == 0 && evt.getDeltaY() == 40) {
        //Mouse Wheel Up
//        Draw2d.setMagnification(true);
//        tgfx.Main.postConsoleMessage("[+]Zooming in " + String.valueOf(Draw2d.getMagnification()) + "\n");
//
//
////        } else if (evt.getDeltaX() == 0 && evt.getDeltaY() == -40) {
////            //Mouse Wheel Down
////            Draw2d.setMagnification(false);
////            tgfx.Main.postConsoleMessage("[+]Zooming out " + String.valueOf(Draw2d.getMagnification()) + "\n");
////        }
//
//
//        if (gcodePane.getChildren().size() > 0) {
//            Iterator ii = gcodePane.getChildren().iterator();
//
//            while (ii.hasNext()) {
//                Line tmpl = (Line) ii.next();
//                tmpl.setStartX(tmpl.getStartX() + 20);
//                tmpl.setStartY(tmpl.getStartY() + 20);
//                tmpl.setEndX(tmpl.getEndY() + 20);
//                tmpl.setEndY(tmpl.getEndY() + 20);
//
////                Path p = new Path();
////                p.setStroke(Color.BLUE);
////                p.getElements().add(tmpl);
//
//            }
//        }
//        //        previewPane.setScaleX(Draw2d.getMagnification());
//        //        previewPane.setScaleY(Draw2d.getMagnification());
//        //        canvsGroup.setScaleX(Draw2d.getMagnification());
//        //        canvsGroup.setScaleY(Draw2d.getMagnification());
    }

//    private void reDrawPreview() {
//        for (Node n : canvsGroup.getChildren()) {
//            Line nd = (Line) n;
//            nd.setStrokeWidth(Draw2d.getStrokeWeight());
//        }
////        tgfx.Main.postConsoleMessage("[+]2d Preview Stroke Width: " + String.valueOf(Draw2d.getStrokeWeight()) + "\n");
//    }
    @FXML
    private void FXreScanSerial(ActionEvent event) {
        this.reScanSerial();
    }

    private void reScanSerial() {
        serialPorts.getItems().clear();
        String portArray[];
        portArray = tg.listSerialPorts();
        serialPorts.getItems().addAll(Arrays.asList(portArray));
    }

    /**
     * These are the actions that need to be ran upon successful serial port
     * connection. If you have something that you want to "auto run" on connect.
     * // * This is the place to do so. This met0 hod is called in
     * handleConnect.
     */
    private void onConnectActions() {
        try {

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    //            Draw2d.setFirstDraw(true);
//          tg.write(CommandManager.CMD_APPLY_ENABLE_JSON_MODE);          //FIRST
//            Thread.sleep(300);
//          
                    int delayValue = 150;
                    try {
                        TinygDriver.getInstance().write(CommandManager.CMD_APPLY_JSON_VOBERSITY);
                        Thread.sleep(delayValue);
//                        tg.write(CommandManager.CMD_APPLY_TEXT_VOBERSITY);
//                        Thread.sleep(delayValue);
                        tg.write(CommandManager.CMD_APPLY_DISABLE_XON_XOFF);        //SECOND
                        Thread.sleep(delayValue);
                        tg.write(CommandManager.CMD_APPLY_STATUS_REPORT_FORMAT);    //THIRD 
                        Thread.sleep(600); //Setting the status report takes some time!  Just leave this alone.  This is a hardware limit..
                        //writing to the eeprom (so many values) is troublesome :)  Like geese.. (this one is for alden)

                        tg.cmdManager.queryAllMachineSettings();                    //SIXtH



                        tg.cmdManager.queryStatusReport();                          //SEVENTH - Get Positions if the board is not at zero
                        tg.cmdManager.queryAllMotorSettings();                      //EIGTH
                        tg.cmdManager.queryAllHardwareAxisSettings();               //NINETH

                        tg.write(CommandManager.CMD_APPLY_TEXT_VOBERSITY);

                        //            tg.write(CommandManager.CMD_APPLY_TEXT_VOBERSITY);          //FORTH
                        //            Thread.sleep(300);
                        //            tg.write(CommandManager.CMD_DEFAULT_ENABLE_JSON);           //FIFTH
                        //            Thread.sleep(300);


                        //            tg.write(CommandManager.CMD_QUERY_SYSTEM_SERIAL_BUFFER_LENGTH);//SECOND.5 :)
                    } catch (Exception ex) {
                        logger.error("Error in OnConnectActions() " + ex.getMessage());
                    }

                }
            });



        } catch (Exception ex) {
            postConsoleMessage("[!]Error in onConnectActions: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void handleConnect(ActionEvent event) throws Exception {
        //Get a list of serial ports on the system.

        if (serialPorts.getSelectionModel().getSelectedItem() == (null)) {
            postConsoleMessage("[+]Error Connecting to Serial Port please select a valid port.\n");
            return;
        }
        if (Connect.getText().equals("Connect") && serialPorts.getSelectionModel().getSelectedItem() != (null)) {
            String serialPortSelected = serialPorts.getSelectionModel().getSelectedItem().toString();

            System.out.println("[+]Connecting...");

            if (!tg.initialize(serialPortSelected, 115200)) {  //This will be true if we connected when we tried to!
                //Our connect attempt failed. 
                postConsoleMessage("[!]There was an error connecting to " + serialPortSelected + " please verify that the port is not in use.\n");
//                consoleAppendMessage("[!]There was an error connecting to " + serialPortSelected + " please verify that the port is not in use.\n");
            }

            if (tg.isConnected()) {

                postConsoleMessage("[+]Connected to " + serialPortSelected + " Serial Port Successfully.\n");
//               tgfx.Main.postConsoleMessage("[+]Connected to " + serialPortSelected + " Serial Port Successfully.\n");
                Connect.setText("Disconnect");

                /**
                 * *****************************
                 * OnConnect Actions Called Here *****************************
                 */
                onConnectActions();
            }
        } else {
            tg.disconnect();
            if (!tg.isConnected()) {
                postConsoleMessage("[+]Disconnected from " + tg.getPortName() + " Serial Port Successfully.\n");
                Connect.setText("Connect");
                onDisconnectActions();
            }

        }
    }

    public void onDisconnectActions() {
        TinygDriver.getInstance().m.setFirmwareBuild(0.0);
        TinygDriver.getInstance().m.firmwareBuild.set(0);
        TinygDriver.getInstance().m.firmwareVersion.set("");
        TinygDriver.getInstance().m.m_state.set("");
        TinygDriver.getInstance().m.setLineNumber(0);
        TinygDriver.getInstance().m.setMotionMode(0);
        Draw2d.setFirstDraw(true);
        TinygDriver.getInstance().serialWriter.resetBuffer();
        //TODO Need to have a way to pull this out of the gcodePane via a message
        //gcodePane.getChildren().remove(cncMachine);
    }

//    private void handleTilda() {
//        //                ==============HIDE CONSOLE CODE==============
//        System.out.println("TILDA");
//        if (topvbox.getChildren().contains(bottom)) {
//            topvbox.getChildren().remove(bottom);
//
//        } else {
//            topvbox.getChildren().add(topvbox.getChildren().size() - 1, bottom);
//        }
//    }
    @FXML
    private void handleKeyInput(final InputEvent event) {
    }

    public static void postConsoleMessage(String message) {
        //This allows us to send input to the console text area on the Gcode Tab.
        final String m = message;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                console.appendText(m + "\n");
            }
        });
    }

//    @FXML
//    private void gcodeProgramClicks(MouseEvent me) {
//        TextField tField = (TextField) gcodesList.getSelectionModel().getSelectedItem();
//        if (me.getButton() == me.getButton().SECONDARY) {
////            tg.write("{\"gc\":\"" + lbl.getText() + "\"}\n");
//            System.out.println("RIGHT CLICKED");
//
//
//        } else if (me.getButton() == me.getButton().PRIMARY && me.getClickCount() == 2) {
//            System.out.println("double clicked");
//            tField.setEditable(true);
//
//            //if (lbl.getParent().getStyleClass().contains("breakpoint")) {
////                lbl.getParent().getStyleClass().remove("breakpoint");
////                tgfx.Main.postConsoleMessage("BREAKPOINT REMOVED: " + lbl.getText() + "\n");
////                System.out.println("BREAKPOINT REMOVED");
////            } else {
////
////                System.out.println("DOUBLE CLICKED");
////                lbl.getStyleClass().removeAll(null);
////                lbl.getParent().getStyleClass().add("breakpoint");
////                System.out.println("BREAKPOINT SET");
////                tgfx.Main.postConsoleMessage("BREAKPOINT SET: " + lbl.getText() + "\n");
////            };
//        }
//    }
    

    @FXML
    private void handleGuiRefresh() throws Exception {
        //Refreshed all gui settings from TinyG Responses.
        if (tg.isConnected()) {

            postConsoleMessage("[+]System GUI Refresh Requested....");
            tg.cmdManager.queryAllHardwareAxisSettings();
            tg.cmdManager.queryAllMachineSettings();
            tg.cmdManager.queryAllMotorSettings();
        } else {
            postConsoleMessage("[!]TinyG Not Connected.. Ignoring System GUI Refresh Request....");
        }
    }

    @FXML
    private void handleKeyPress(final InputEvent event) throws Exception {
        //private void handleEnter(ActionEvent event) throws Exception {
        final KeyEvent keyEvent = (KeyEvent) event;
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            String command = (input.getText() + "\n");
            logger.info("Entered Command: " + command);
            if (!tg.isConnected()) {
                logger.error("TinyG is not connected....\n");
                postConsoleMessage("[!]TinyG is not connected....\n");
                input.setPromptText(PROMPT);
                return;
            }
            //TinyG is connected... Proceed with processing command.
            //This will send the command to get a OK prompt if the buffer is empty.
            if ("".equals(command)) {
                tg.write(CommandManager.CMD_QUERY_OK_PROMPT);
            }
            tg.write(command);
            postConsoleMessage(command);
            gcodeCommandHistory.addCommandToHistory(command);  //Add this command to the history
            input.clear();
            input.setPromptText(PROMPT);
        } else if (keyEvent.getCode().equals(KeyCode.UP)) {
            input.setText(gcodeCommandHistory.getNextHistoryCommand());
        } else if (keyEvent.getCode().equals(KeyCode.DOWN)) {
            input.setText(gcodeCommandHistory.getPreviousHistoryCommand());
        } else if (keyEvent.getCode().equals(KeyCode.F5)) {
            postConsoleMessage("[+]System GUI State Requested....");
            tg.cmdManager.queryAllHardwareAxisSettings();
            tg.cmdManager.queryAllMachineSettings();
            tg.cmdManager.queryAllMotorSettings();
        }
    }

    private Task initRemoteServer(String port) {
        final String Port = port;
        return new Task() {
            @Override
            protected Object call() throws Exception {
                SocketMonitor sm = new SocketMonitor(Port);

                System.out.println("[+]Trying to start remote monitor.");
                return true;
            }
        };
    }

    

//    private void updateGuiMachineSettings(String line) {
//        final String l = line;
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                //We are now back in the EventThread and can update the GUI
//                try {
//                    Machine m = TinygDriver.getInstance().m;
////                    srBuild.setText(String.valueOf(m.getFirmwareBuild()));
////                    srVer.setText(String.valueOf(m.getFirmwareVersion()));
////                    gcodePlane.getSelectionModel().select(TinygDriver.getInstance().m.getGcode_select_plane().ordinal());
////                    gcodeUnitMode.getSelectionModel().select(TinygDriver.getInstance().m.getGcodeUnitMode());
////                    gcodeCoordSystem.getSelectionModel().select(TinygDriver.getInstance().m.getCoordinateSystem().ordinal());
////                    gcodePathControl.getSelectionModel().select(TinygDriver.getInstance().m.getGcode_distance_mode().ordinal());
////                    gcodeDistanceMode.getSelectionModel().select(TinygDriver.getInstance().m.getGcode_distance_mode().ordinal());
//
////                    if (m.getCoordinateSystem() != null) {
////                        srCoord.setText(TinygDriver.getInstance().m.getCoordinateSystem().toString());
////                    }
//                } catch (Exception ex) {
//                    System.out.println("[!] Exception in updateGuiMachineSettings");
//                    System.out.println(ex.getMessage());
//                }
//            }
//        });
//
//    }
    @Override
    public synchronized void update(Observable o, Object arg) {
//
//        //We process status code messages here first.
        if (arg.getClass().getCanonicalName().equals("tgfx.system.StatusCode")) {
            //We got an error condition.. lets route it to where it goes!
            StatusCode statuscode = (StatusCode) arg;
            postConsoleMessage("[->] TinyG Response: " + statuscode.getStatusType() + ":" + statuscode.getMessage() + "\n");
        } else {
            try {
                final String[] UPDATE_MESSAGE = (String[]) arg;
                final String ROUTING_KEY = UPDATE_MESSAGE[0];
                final String KEY_ARGUMENT = UPDATE_MESSAGE[1];

                /**
                 * This is our update routing switch From here we update
                 * different parts of the GUI that is not bound to properties.
                 */
                switch (ROUTING_KEY) {
                    case ("STATUS_REPORT"):
//                        drawCanvasUpdate(ROUTING_KEY);  
                        //TODO we need to push this into a message as well.
                        break;
                    case ("CMD_GET_AXIS_SETTINGS"):
                        TinyGConfigController.updateGuiAxisSettings(KEY_ARGUMENT);
                        break;
                    case ("CMD_GET_MACHINE_SETTINGS"):
                        //updateGuiMachineSettings(ROUTING_KEY);
                        break;
                    case ("CMD_GET_MOTOR_SETTINGS"):
                         TinyGConfigController.updateGuiMotorSettings(KEY_ARGUMENT);
                        break;
                    case ("NETWORK_MESSAGE"):
                        //updateExternal();
                        break;
                    case ("MACHINE_UPDATE"):
                        MachineSettingsController.updateGuiMachineSettings(); 

                        break;
                    case ("TEXTMODE_REPORT"):
                        postConsoleMessage(KEY_ARGUMENT);
                        break;
                    case ("BUFFER_UPDATE"):
                        srBuffer.setText(KEY_ARGUMENT);
                        break;
                    case ("UPDATE_LINE_NUMBER"):
                        srGcodeLine.setText(KEY_ARGUMENT);
                        break;
                    case ("TINYG_USER_MESSAGE"):

                        //TODO: create a pubsub message for this as well.
//                        tgfx.Main.postConsoleMessage("TinyG Board Message >> " + KEY_ARGUMENT);
////                        Thread.sleep(1000);//we need to let the board load its configs
//                        tg.cmdManager.queryStatusReport();
//                        if (KEY_ARGUMENT.trim().equals("SYSTEM READY")) {
//                            cncMachine.resetDrawingCoords();  //So we do not draw a line from the previous coordinate.
//                            onConnectActions(); //rerun this as we were reset.
//                            //TODO make it so we can un-set a flag here when the board has been fully reset
//                            //perhaps we hide a gui object
//
//                            //Re-Enable the gui
//                            if (topTabPane.isDisable() || topAnchorPane.isDisable()) {
//                                topTabPane.setDisable(false);
//                                topAnchorPane.setDisable(false);
//                                logger.info("Re-Enabling the UI");
//                                tgfx.Main.postConsoleMessage("TinyG Re-Connected.. Enabling UI\n");
//                            }
//                        }
                        break;


                    default:
                        System.out.println("[!]Invalid Routing Key: " + ROUTING_KEY);




                }
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Main.class
                        .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

   

    private Lcd buildSingleDRO(Lcd tmpLcd, StyleModel sm, String title, String units) {
        tmpLcd = LcdBuilder.create()
                .styleModel(sm)
                .threshold(30)
                .title(title)
                .unit(units)
                .build();
        tmpLcd.setPrefSize(200, 70);
        return tmpLcd;

    }

    public static final String getBuildInfo(String propToken) {
        String msg = "";
        try {
            msg = rb.getString(propToken);
        } catch (MissingResourceException e) {
            logger.error("Error Getting Build Info Token ".concat(propToken).concat(" not in Propertyfile!"));
        }
        return msg;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*####################################
         *MISC INIT CODE 
         #################################### */

        tg.resParse.addObserver(this);  //Add the tinygdriver to this observer
        this.reScanSerial();            //Populate our serial ports
        final Logger logger = Logger.getLogger(Main.class);


        /*#######################################################
         * BINDINGS
         * #####################################################*/

        StringConverter sc = new StringConverter<Number>() {
            @Override
            public String toString(Number n) {
                return String.valueOf(n.floatValue());
            }

            @Override
            public Number fromString(String s) {
                return Integer.valueOf(s);
            }
        };

        srMomo.textProperty()
                .bind(TinygDriver.getInstance().m.getMotionMode());
        srVer.textProperty()
                .bind(TinygDriver.getInstance().m.firmwareVersion);

        srBuild.textProperty()
                .bindBidirectional(TinygDriver.getInstance().m.firmwareBuild, sc);
        srState.textProperty()
                .bind(TinygDriver.getInstance().m.m_state);
        srCoord.textProperty()
                .bind(TinygDriver.getInstance().m.getCoordinateSystem());
        srUnits.textProperty()
                .bind(TinygDriver.getInstance().m.getGcodeUnitMode());



//        widthSize.textProperty().bind( Bindings.format("%s",  cncMachine.widthProperty().divide(TinygDriver.getInstance().m.gcodeUnitDivision).asString().concat(TinygDriver.getInstance().m.getGcodeUnitMode())    ));  //.asString().concat(TinygDriver.getInstance().m.getGcodeUnitMode().get()));
//        widthSize.textProperty().bind(cncWidthString);  //.asString().concat(TinygDriver.getInstance().m.getGcodeUnitMode().get()));
//        heightSize.textProperty().bind(cncMachine.heightProperty().divide(TinygDriver.getInstance().m.gcodeUnitDivision).asString().concat(TinygDriver.getInstance().m.getGcodeUnitMode()));



        srCoord.textProperty()
                .bind(TinygDriver.getInstance().m.gcm.getCurrentGcodeCoordinateSystemName());
        srGcodeLine.textProperty()
                .bind(TinygDriver.getInstance().m.getLineNumberSimple().asString());
//TODO: FIX THIS


//        cncMachine.scaleXProperty().bind(cncMachine.widthProperty().subtract(gcodePane.widthProperty()));
//        cncMachine.scaleYProperty().bind(gcodePane.heightProperty().subtract(cncMachine.heightProperty().multiply(.9)));


        /*
         * If unit=mm 
         work_position = mpo_ - ofs_
         If unit=in
         work_position = (mpo_ - ofs_) / 25.4
         A is always 
         work_position_a = mpoa - ofsa
         */







        /*######################################
         * LOGGER CONFIG
         ######################################*/
        BasicConfigurator.configure();

        logger.setLevel(Level.ERROR);
//        logger.setLevel(Level.INFO);

        logger.info(
                "[+]tgFX is starting....");



        /*##########################
         * SOCKET NETWORK INIT CODE
         ##########################/*
         //SocketMonitor sm;
         //Thread remoteListener = new Thread(initRemoteServer("8888"));
         //remoteListener.setName("Remote Listener Thread");
         //remoteListener.start();

        
         /*######################################
         * WEB PAGE SUPPORT
         ######################################*/

        final WebEngine webEngine = html.getEngine();
        final WebEngine webEngine2 = makerCam.getEngine();

        Platform.runLater(
                new Runnable() {
            @Override
            public void run() {
                webEngine.load("https://github.com/synthetos/TinyG/wiki");
                webEngine2.load("http://simplegcoder.com/js_editor/");
            }
        });


        /*######################################
         * THREAD INITS
         ######################################*/

        Thread serialWriterThread = new Thread(tg.serialWriter);

        serialWriterThread.setName(
                "SerialWriter");
        serialWriterThread.setDaemon(
                true);
        serialWriterThread.start();
        Thread threadResponseParser = new Thread(tg.resParse);

        threadResponseParser.setDaemon(
                true);
        threadResponseParser.setName(
                "ResponseParser");
        threadResponseParser.start();

        /*#################################################################
         * CHANGE LISTENERS
         ##################################################################*/
        /*############################################
         * BUILD VERSIONING CODE
         ############################################*/
//        buildNumber = Integer.valueOf(getBuildInfo("BUILD").replace(",", ""));
//        buildDate = getBuildInfo("DATE");
//
//        //Set our build / versions in the tgFX settings tab.
//        tgfxBuildDate.setText(buildDate);
        tgfxBuildNumber.setText(getBuildInfo("BUILD"));
        tgfxVersion.setText(
                ".95");

        tgfxBuildDate.setId(
                "lblMachine");
        tgfxBuildNumber.setId(
                "lblMachine");
        tgfxVersion.setId(
                "lblMachine");


    }
}

//  
