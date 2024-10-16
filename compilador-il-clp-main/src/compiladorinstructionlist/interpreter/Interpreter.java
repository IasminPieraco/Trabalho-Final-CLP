package compiladorinstructionlist.interpreter;

import compiladorinstructionlist.memoryvariable.MemoryVariable;
import compiladorinstructionlist.screen.InterfaceScreen;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Classe que interpreta as intruções
public class Interpreter {
    
    // Cria variáveis
    static Boolean accumulator;
    static List<String> validOperators = new ArrayList<String>();
    
    // Define operadores válidos
    public static void initializeValidOperators() {
        validOperators.add("LD");
        validOperators.add("LDN");
        validOperators.add("ST");
        validOperators.add("STN");
        validOperators.add("AND");
        validOperators.add("ANDN");
        validOperators.add("OR");
        validOperators.add("ORN");
        validOperators.add("TON");
    }
    
    // Recebe linhas vindas da tela e separa operador e variável
    public static Map receiveLines(List<String> lineList, Map<String, Boolean> inputs, Map<String, Boolean> outputs, Map<String, MemoryVariable> memoryVariables) {
        
        // Variáveis auxiliares
        char character = '-';
        Boolean spaceDetected = false;
        String operator = "";
        String variable = "";
        ArrayList<String> variables = new ArrayList();
        Boolean justEmptyLines = true;
        
        initializeValidOperators();
        
        // Limpa hash de variáveis de memória e saídas
        memoryVariables.clear();
        
        // Limpa acumulador
        accumulator = null;
        
        // Itera lista de linhas
        for (int i = 0; i < lineList.size(); i++) {
            Integer currentLine = i + 1;
            System.out.println("\n-> Linha: " + currentLine.toString());
            
            // Ignora linhas vazias
            if(!lineList.get(i).isBlank()) {
                justEmptyLines = false;
                // Itera caracteres da linha
                for (int j = 0; j < lineList.get(i).length(); j++) {
                    character = lineList.get(i).charAt(j);

                    if (character != ' ' && character != '\n' && character != '\t' && character != ',' && !spaceDetected) {
                        operator = operator + character;
                    } 

                    if((character == ' ' || character == '\t') && !operator.equals("")) {
                        spaceDetected = true;
                    }
                    
                    if(character == ',' && !operator.equals("")){
                        variables.add(variable);
                        variable = "";
                    }

                    if (character != ' ' && character != '\n' && character != '\t' && character != ',' && spaceDetected) {
                        variable = variable + character;
                    }
                }

                variables.add(variable);
                
                System.out.println("Operador: " + operator);
                System.out.println("Variável: " + variables);

                outputs = executeInstruction(operator, variables, inputs, outputs, memoryVariables);
            }
            
            spaceDetected = false;
            operator = "";
            variable = "";
            variables.clear();
        }
        
        if(justEmptyLines) {
            InterfaceScreen.showErrorMessage("Insira as intruções para o CLP!");
        }
        
        return outputs;
    }
    
    // Verifica se operador é válido
    public static boolean operatorIsValid(String operator) {
        Boolean isValid = false;
        for(int i = 0; i < validOperators.size(); i++){
            if(!isValid && validOperators.get(i).equals(operator)){
                isValid = true;
                System.out.println("Operador válido!");
            } 
        }
        return isValid;
    }
    
    // Verifica se entrada é válido
    public static boolean inputIsValid(ArrayList<String> variables, Map<String, Boolean> inputs) {
        Boolean isValid = true;
        
        if (inputs.get(variables.get(0)) == null) {
            isValid = false;
            System.out.println("Não é uma entrada válida!");
        }
        return isValid;
    }
    
    // Verifica se saída é válida
    public static boolean outputIsValid(ArrayList<String> variables, Map<String, Boolean> outputs) {
        Boolean isValid = true;
        
        if (outputs.get(variables.get(0)) == null) {
            isValid = false;
            System.out.println("Não é uma saída válida!");
        }
        return isValid;
    }
    
    // Verifica se variável de memória é válida
    public static boolean memoryVariableIsValid(ArrayList<String> variables, Map<String, MemoryVariable> memoryVariables) {
        Boolean isValid = true;
        
        if (memoryVariables.get(variables.get(0)) == null) {
            isValid = false;
            System.out.println("Não é uma memória válida!");
        }
        return isValid;
    }
    
    // Executa instruções
    public static Map executeInstruction(String operator, ArrayList<String> variables, Map<String, Boolean> inputs, Map<String, Boolean> outputs, Map<String, MemoryVariable> memoryVariables) {
        System.out.println(variables.get(0));
        // Caso operador seja válido e tenhamos como variável uma entrada ou uma saída
        if(operatorIsValid(operator) && (inputIsValid(variables, inputs) || outputIsValid(variables, outputs))) { 
        
            // Carrega entrada ou saída para o acumulador
            if(operator.equals("LD")){
                if(variables.get(0).charAt(0) == 'I'){
                    accumulator = inputs.get(variables.get(0));
                }
                
                if(variables.get(0).charAt(0) == 'Q'){
                    accumulator = outputs.get(variables.get(0));
                }
            }

            // Carrega entrada ou saída negada para o acumulador
            if(operator.equals("LDN")){
                if(variables.get(0).charAt(0) == 'I'){
                    accumulator = !(inputs.get(variables.get(0)));
                }
                
                if(variables.get(0).charAt(0) == 'Q'){
                    accumulator = !(outputs.get(variables.get(0)));
                }
            }
            
            // Verifica se o valor do acumulador não é nulo
            if(accumulator != null) {
                if (operator.equals("ST") || operator.equals("STN")) {
                    if(outputIsValid(variables, outputs)) {
                        // Carrega o valor do acumulador para a variável (saída)
                        if(operator.equals("ST")){
                            if(variables.get(0).charAt(0) == 'Q'){
                                outputs.put(variables.get(0), accumulator);
                            }
                        }

                        // Carrega o valor do acumulador negado para a variável (saída)
                        if(operator.equals("STN")){
                            if(variables.get(0).charAt(0) == 'Q'){
                                outputs.put(variables.get(0), !accumulator);
                            }
                        }
                    } else {
                        InterfaceScreen.showErrorMessage("Entradas não podem ser modificadas, portanto, operadores ST e STN não são válidos para entradas!");
                    }
                }

                // Faz operação AND entre o acumulador e a variável (entrada ou saída) e salva no acumulador
                if(operator.equals("AND")){
                    if(variables.get(0).charAt(0) == 'I'){
                        accumulator = (accumulator && inputs.get(variables.get(0)));
                    }

                    if(variables.get(0).charAt(0) == 'Q'){
                        accumulator = (accumulator && outputs.get(variables.get(0)));
                    }
                }

                // Faz operação AND entre o acumulador e a variável (entrada ou saída) negada e salva no acumulador
                if(operator.equals("ANDN")){
                    if(variables.get(0).charAt(0) == 'I'){
                        accumulator = (accumulator && !(inputs.get(variables.get(0))));
                    }

                    if(variables.get(0).charAt(0) == 'Q'){
                        accumulator = (accumulator && !(outputs.get(variables.get(0))));
                    }
                }

                // Faz operação OR entre o acumulador e a variável (entrada ou saída) e salva no acumulador
                if(operator.equals("OR")){
                    if(variables.get(0).charAt(0) == 'I'){
                        accumulator = (accumulator || inputs.get(variables.get(0)));
                    }

                    if(variables.get(0).charAt(0) == 'Q'){
                        accumulator = (accumulator || outputs.get(variables.get(0)));
                    }
                }

                // Faz operação OR entre o acumulador e a variável (entrada ou saída) negada e salva no acumulador
                if(operator.equals("ORN")){
                    if(variables.get(0).charAt(0) == 'I'){
                        accumulator = (accumulator || !(inputs.get(variables.get(0))));
                    }

                    if(variables.get(0).charAt(0) == 'Q'){
                        accumulator = (accumulator || !(outputs.get(variables.get(0))));
                    }
                }

                System.out.println("Acumulador: " + accumulator);
                System.out.println("Entradas: " + inputs);
                System.out.println("Saídas: " + outputs);
            } else {
                InterfaceScreen.showErrorMessage("Acumulador vazio! Carregue inicialmente a variável desejada para o acumulador com as funções LD ou LDN!");
            }
            
        // Caso operador seja válido e tenhamos como variável uma memória
        } else if(operatorIsValid(operator) && !inputIsValid(variables, inputs) && !outputIsValid(variables, outputs)){
            // Para operações de carregamento (onde variável de memória são criadas)
            if(operator.equals("ST") || operator.equals("STN") || operator.equals("TON")){
                // Se memória já existe, só atualiza no hash
                if(memoryVariableIsValid(variables, memoryVariables)) {
                    if(operator.equals("ST")){
                        memoryVariables.get(variables.get(0)).currentValue = accumulator;
                    }

                    if(operator.equals("STN")){
                        memoryVariables.get(variables.get(0)).currentValue = !accumulator;
                    }
                    
                    if(operator.equals("TON")){
                        memoryVariables.get(variables.get(0)).maxTimer = Integer.parseInt(variables.get(1));
                    }
                // Se memória não existe, ela é criada e e guardada no hash
                } else {
                    if(operator.equals("ST")){
                        memoryVariables.put(variables.get(0), new MemoryVariable(variables.get(0)));
                        memoryVariables.get(variables.get(0)).currentValue = accumulator;
                    }

                    if(operator.equals("STN")){
                        memoryVariables.put(variables.get(0), new MemoryVariable(variables.get(0)));
                        memoryVariables.get(variables.get(0)).currentValue = accumulator;
                    }
                    
                    if(operator.equals("TON")){
                        memoryVariables.put(variables.get(0), new MemoryVariable(variables.get(0)));
                        memoryVariables.get(variables.get(0)).maxTimer = Integer.parseInt(variables.get(1));
                    }
                }
                System.out.println("Acumulador: " + accumulator);
                System.out.println("Entradas: " + inputs);
                System.out.println("Saídas: " + outputs);
                System.out.println("Variáveis de memória: " +memoryVariables);
            // Outras operações
            } else {
                // Memória precisa existir
                if(memoryVariableIsValid(variables, memoryVariables)) {
                    if(operator.equals("LD")){
                        accumulator = variables.get(0).charAt(0) == 'T' ? memoryVariables.get(variables.get(0)).endTimer : memoryVariables.get(variables.get(0)).currentValue;
                    }

                    if(operator.equals("LDN")){
                        accumulator = variables.get(0).charAt(0) == 'T' ? !memoryVariables.get(variables.get(0)).endTimer : !memoryVariables.get(variables.get(0)).currentValue;
                    }
                    
                    if(operator.equals("AND")){
                        accumulator = variables.get(0).charAt(0) == 'T' ? (accumulator && memoryVariables.get(variables.get(0)).endTimer) : (accumulator && memoryVariables.get(variables.get(0)).currentValue);
                    }

                    if(operator.equals("ANDN")){
                        accumulator = variables.get(0).charAt(0) == 'T' ? (accumulator && !memoryVariables.get(variables.get(0)).endTimer) : (accumulator && !memoryVariables.get(variables.get(0)).currentValue);
                    }
                    
                    if(operator.equals("OR")){
                        accumulator = variables.get(0).charAt(0) == 'T' ? (accumulator || memoryVariables.get(variables.get(0)).endTimer) : (accumulator || memoryVariables.get(variables.get(0)).currentValue);
                    }
                    
                    if(operator.equals("ORN")){
                        accumulator = variables.get(0).charAt(0) == 'T' ? (accumulator || !memoryVariables.get(variables.get(0)).endTimer) : (accumulator || !memoryVariables.get(variables.get(0)).currentValue);
                    }
                    
                    System.out.println(accumulator);
                    System.out.println(inputs);
                    System.out.println(outputs); 
                    System.out.println(memoryVariables);
                } else {
                    InterfaceScreen.showErrorMessage("Sintaxe incorreta! Variável " + variables + " não existe!");
                }
            }
        } else {
            InterfaceScreen.showErrorMessage("Sintaxe incorreta! Operador " + operator + " não existe!");
        }
        
        System.out.println(accumulator);
        return outputs;
    }  
}