package compiladorinstructionlist.memoryvariable;

// Classe variável de memória

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MemoryVariable {
    public String id;
    public Boolean currentValue;
    public Boolean endTimer;
    public int counter;
    public int maxTimer;
    public Timer timer;
    public String timerType;

    public MemoryVariable(String id) {
        this.id = id;
        this.counter = 0;
        this.currentValue = false;
        this.maxTimer = 0;
        this.endTimer = false;
        this.timerType = "";
        this.timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(counter<maxTimer){
                    counter++;
                }
                if(counter == maxTimer){
                    if(timerType.equals("ON"))
                        endTimer = true;
                    else if(timerType.equals("OFF"))
                        endTimer = false;
                    timer.stop();
                }
            }
        });
    }
    
    public String getMemory(){
        if(id.charAt(0) == 'M'){
            return "Boolean memory: "+id+", State:"+currentValue;
        }else if(id.charAt(0) == 'T'){
            if(timerType.equals("ON")){
                return "Timer On memory: "+id+", State:"+currentValue+", Accum:"+counter+", Preset:"+maxTimer+", DN:"+endTimer;
            }else if(timerType.equals("OFF")){
                return "Timer Off memory: "+id+", State:"+currentValue+", Accum:"+counter+", Preset:"+maxTimer+", DN:"+endTimer;
            }else{
                return "Timer type error";
            }
        }
            
        return "Memory type error";
    }

    public String getTimerType(){
        return timerType;
    }
    
    public String getTimer() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Boolean getDN(){
        return this.endTimer;
    }
    
    public Boolean getEN(){
        return this.currentValue;
    }
    
    public int getAccum(){
        return this.counter;
    }
    
    public int getPreset(){
        return this.maxTimer;
    }
    
    public Boolean getEndCounter(){
        return this.endTimer;
    }

    public Boolean getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Boolean currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return "MemoryVariable{" + "id=" + id + ", currentValue=" + currentValue + '}';
    }
}
