/****************************************************************
 * Šioje klasėje pateikiami JavaFX grafikos transformacijų pavyzdžiai
 * https://o7planning.org/en/11157/javafx-transformations-tutorial
 * 
 * Pradžioje vykdykite kodą ir stebėkite atliekamus veiksmus
 * Užduotis atlikite sekdami nurodymus programinio kodo komentaruose
 * Gynimo metu atlikite dėstytojo nurodytas užduotis naujų metodų pagalba.
 *
 * @author Eimutis Karčiauskas, KTU programų inžinerijos katedra 2019 08 05
 **************************************************************************/
package demos.graphics;

import extendsFX.BaseGraphics;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Demo2_Transform extends BaseGraphics {
    private VisualParameters vip = null;
    
    // rinkinys figūrų, kurios brėžiamos atlikus transformacijas
    // UŽDUOTIS: sukurkite savo figūrų rinkinį, kurį transformuosite
    private void drawSuite1() { 
        gc.setFill(randomColor());
        gc.fillRect(0, 0, 30, 40);
        gc.setFill(randomColor());
        gc.fillOval(0, 0, 30, 40);
        gc.setLineWidth(0.6);
        gc.setStroke(Color.BLACK);
        gc.strokeText("Hello",0, 50);
    }
    
     private void drawSuite2() { 
        gc.setFill(randomColor());
        gc.fillRoundRect(0.0, 0.0, 30.0, 40.0, 2.0, 2.0);
        gc.setFill(randomColor());
        double[] polX = {1.13, 2.10, 3.36};
        double[] polY = {2.16,3.14,2.20};
        gc.fillPolygon(polX, polY, 3);
        gc.setLineWidth(0.6);
        gc.setStroke(Color.BLACK);
        gc.strokeText("Hello",0, 50);
    }
     
      
     
      private void drawSuite3() { 
        gc.setFill(randomColor());
        gc.fillRoundRect(0.0, 0.0, 20.0, 400.0, 4.0, 2.0);
        gc.setFill(randomColor());
        double[] polX = {1.13, 2.10, 1.6};
        double[] polY = {2.16,3.14,2.20};
        gc.fillPolygon(polX, polY, 3);

    }
     
     

    @Override
    public void createControls(){
        vip = new VisualParameters();
        addNewHBox();
        addButton("clear", e -> {gc.restore(); clearCanvas(); gc.save();}); 
        addButton("grid",  e -> baseGrid());
        addButton("translate", e -> gc.translate(vip.stepX(), vip.stepY()));
        addButton("scale+", e -> gc.scale(2, 2));
        addButton("scale-", e -> gc.scale(0.5, 0.5));
        addButton("rotate", e -> gc.rotate(vip.rotateAngle()));
        addButton("draw1",   e -> drawSuite1());
         addButton("draw2",   e -> drawSuite2());
         addButton("draw3Mano",   e -> drawSuite3());
    }
// DĖMESIO - tai speciali klasė, kurioje saugojami vizualių parametų komponentai
// Juose užfiksuotos reikšmė gražinamos tam skirtų metodų pagalba.
// Kadangi žinomas gražinamos reikšmės tipas, tai atliekama būtina konversija.
    private class VisualParameters{
        final private TextField tfStepX = addTextField("stepX=", "100", 35);
        final private TextField tfStepY = addTextField("stepY=", "100", 35);
        final private TextField tfRotateAngle = addTextField
                                ("rotateAngle=", "-30", 40);
        double stepX(){ 
            return Double.parseDouble(tfStepX.getText());
        }
        double stepY() {
            return Double.parseDouble(tfStepY.getText());
        }
        double rotateAngle() {
            return Double.parseDouble(tfRotateAngle.getText());
        }
    }    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFX transformacijų tyrimas © Eimutis");
        setCanvas(Color.CYAN.brighter(), 600, 400);
        super.start(stage);
        gc.save();
    }       
    public static void main(String[] args) {
        launch(args);
    }    
}
