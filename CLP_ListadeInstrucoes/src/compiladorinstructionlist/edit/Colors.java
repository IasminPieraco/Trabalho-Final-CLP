package compiladorinstructionlist.edit;

import java.awt.Color;

public class Colors {
    
    public static Color firstColor(int color){
        switch (color) {
            case 1:
                return new Color(8,94,131);
            case 2:
                return new Color(0,66,2);
            case 3:
                return new Color(99,58,1);
            case 4:
                return new Color(85,0,0);
            default:
                return new Color(100,100,100);
        }
    }
    
    public static Color secondColor(int color){
        switch (color) {
            case 1:
                return new Color(142,177,199);
            case 2:
                return new Color(181,198,169);
            case 3:
                return new Color(198,188,169);
            case 4:
                return new Color(198,169,169);
            default:
                return new Color(150,150,150);
        }
    }
    
    public static Color thirdColor(int color){
        switch (color) {
            case 1:
                return new Color(131,177,246);
            case 2:
                return new Color(126,205,165);
            case 3:
                return new Color(220,216,169);
            case 4:
                return new Color(220,169,169);
            default:
                return new Color(200,200,200);
        }
    }
    
}
