import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Temperature_Converter 
{
    public static void main(String[] args) 
    {
        JFrame fr=new JFrame("Temperature Converter");

        JLabel h1=new JLabel("Temperature Converter");
        h1.setFont(new Font("Arial", Font.BOLD, 20));

        //Input component section start
        JLabel inputLabel=new JLabel("Enter Temperature value :");
        JLabel inputUnitLabel=new JLabel("Input Unit :");
        TextField inputField=new TextField();
        Choice inputUnitChoice=new Choice();
        inputUnitChoice.add("Celsius");
        inputUnitChoice.add("Fahrenheit");
        inputUnitChoice.add("Kelvin");
        inputUnitChoice.add("Rankine");
        inputUnitChoice.add("Reaumur");
        inputUnitChoice.add("Delisle");
        inputUnitChoice.add("Newton");
        inputUnitChoice.add("Romer");
        //Input component section end
        
        //Output component section start
        JLabel outputLabel=new JLabel("Converted Temperature  :");
        JLabel outputUnitLabel=new JLabel("Output Unit :");
        TextField outputField=new TextField();
        Choice outputUnitChoice=new Choice();
        outputUnitChoice.add("Celsius");
        outputUnitChoice.add("Fahrenheit");
        outputUnitChoice.add("Kelvin");
        outputUnitChoice.add("Rankine");
        outputUnitChoice.add("Reaumur");
        outputUnitChoice.add("Delisle");
        outputUnitChoice.add("Newton");
        outputUnitChoice.add("Romer");
        //Output component section start

        //Button section start
        JButton cal=new JButton("Calculate");
        JButton resJButton=new JButton("Reset");
        JButton swapButton=new JButton("Swap");
        //Button section end

        //Conversion status field section start
        TextField errorField = new TextField();
        JLabel errorFieldlabel=new JLabel("Conversion Status :");
        //Conversion status field section end

        //Positioning components in frame section start
        h1.setBounds(100, 10, 300, 30);

        inputLabel.setBounds(20, 50, 150, 50);
        inputUnitLabel.setBounds(105,90,70,30);
        inputField.setBounds(180, 65, 160, 25);
        inputUnitChoice.setBounds(180, 95, 160, 40);

        outputLabel.setBounds(20, 210, 150, 50);
        outputUnitLabel.setBounds(95, 120, 70, 30);
        outputField.setBounds(180, 225, 160, 25);
        outputUnitChoice.setBounds(180, 125, 160, 40);

        resJButton.setBounds(20, 175, 100, 30);
        cal.setBounds(130, 175, 100, 30);
        swapButton.setBounds(240, 175, 100, 30);
        errorField.setBounds(180, 265, 160, 25);
        errorFieldlabel.setBounds(53, 250, 150, 50);
        //Positioning components in frame section end

        //Adding components in frame section start
        fr.add(h1);

        fr.add(inputLabel);
        fr.add(inputUnitLabel);
        fr.add(inputField);
        fr.add(inputUnitChoice);
        
        fr.add(outputLabel);
        fr.add(outputUnitLabel);
        fr.add(outputField);
        fr.add(outputUnitChoice);

        fr.add(resJButton);
        fr.add(cal);
        fr.add(swapButton);
        fr.add(errorField);
        fr.add(errorFieldlabel);
        //Adding components in frame section end

        //Reset Actionlistener section start
        resJButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                //Reset TextField values
                inputField.setText("");
                outputField.setText("");

                //Reset ComboBox values
                inputUnitChoice.select("");
                outputUnitChoice.select("");

                //Display conversion status
                errorField.setText("Reset successful!");
            }
        });
        //Reset Actionlistener section end

        //Calculate Actionlistener section start
        cal.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                Double inputval;
                try
                {
                    inputval=Double.parseDouble(inputField.getText());
                }
                catch(Exception r)
                {
                    errorField.setText("Error : Invalid input!!");
                    return;
                }
                String choice_in=(String)inputUnitChoice.getSelectedItem();
                String choice_out=(String)outputUnitChoice.getSelectedItem();
                switch (choice_in) 
                {
                    //Celsius case section start
                    case "Celsius":
                        switch (choice_out) 
                        {
                            case "Celsius":
                            outputField.setText(String.valueOf(inputval));
                                break;

                            case "Fahrenheit":
                            outputField.setText(String.valueOf((inputval * 9.0 / 5.0) + 32.0));
                                break;
                        
                            case "Kelvin":
                            outputField.setText(String.valueOf(inputval + 273.15));
                                break;

                            case "Rankine":
                            outputField.setText(String.valueOf((inputval + 273.15)* 9.0 / 5.0));
                                break;

                            case "Reaumur":
                            outputField.setText(String.valueOf(inputval* 4.0 / 5.0));
                                break;

                            case "Delisle":
                            outputField.setText(String.valueOf(((100.0 - inputval) * 3.0 / 2.0)));
                                break;

                            case "Newton":
                            outputField.setText(String.valueOf((inputval * 33.0 / 100.0)));
                                break;

                            case "Romer":
                            outputField.setText(String.valueOf((inputval * 21.0 / 40.0) + 7.5));
                                break;

                            default:
                                errorField.setText("Error : Invalid input!!");
                                break;
                        }
                        errorField.setText("Conversion successful!");
                        break;
                    //Celsius case section end

                    //Fahrenheit case section start
                    case "Fahrenheit":
                        switch (choice_out) 
                        {
                            case "Celsius":
                            outputField.setText(String.valueOf(((inputval - 32.0) * 5.0 / 9.0)));
                                break;

                            case "Fahrenheit":
                            outputField.setText(String.valueOf(inputval));
                                break;
                        
                            case "Kelvin":
                            outputField.setText(String.valueOf(((inputval + 459.67) * 5.0 / 9.0)));
                                break;

                            case "Rankine":
                            outputField.setText(String.valueOf(inputval + 459.67));
                                break;

                            case "Reaumur":
                            outputField.setText(String.valueOf(((inputval - 32.0) * 4.0 / 9.0)));
                                break;

                            case "Delisle":
                            outputField.setText(String.valueOf(((212.0 - inputval) * 5.0 / 6.0)));
                                break;

                            case "Newton":
                            outputField.setText(String.valueOf(((inputval - 32.0) * 11.0 / 60.0)));
                                break;

                            case "Romer":
                            outputField.setText(String.valueOf(((inputval - 32.0) * 7.0 / 24.0 + 7.5)));
                                break;

                            default:
                                errorField.setText("Error : Invalid input!!");
                                break;
                        }
                        errorField.setText("Conversion successful!");
                        break;
                    //Fahrenheit case section end

                    //Kelvin case section start
                    case "Kelvin":
                        switch (choice_out) 
                        {
                            case "Celsius":
                            outputField.setText(String.valueOf(inputval - 273.15));
                                break;

                            case "Fahrenheit":
                            outputField.setText(String.valueOf((inputval * 9.0/5.0) - 459.67));
                                break;
                        
                            case "Kelvin":
                            outputField.setText(String.valueOf(inputval));
                                break;

                            case "Rankine":
                            outputField.setText(String.valueOf(inputval * 9.0/5.0));
                                break;

                            case "Reaumur":
                            outputField.setText(String.valueOf((inputval - 273.15) * 4.0/5.0));
                                break;

                            case "Delisle":
                            outputField.setText(String.valueOf((373.15 - inputval) * 3.0/2.0));
                                break;

                            case "Newton":
                            outputField.setText(String.valueOf((inputval - 273.15) * 33.0/100.0));
                                break;

                            case "Romer":
                            outputField.setText(String.valueOf((inputval - 273.15) * 21.0/40.0 + 7.5));
                                break;

                            default:
                                errorField.setText("Error : Invalid input!!");
                                break;
                        }
                    errorField.setText("Conversion successful!");
                    break;
                //Kelvin case section end

                //Rankine case section start
                 case "Rankine":
                    switch (choice_out) 
                    {
                        case "Celsius":
                        outputField.setText(String.valueOf(((inputval - 491.67) * 5.0/9.0)));
                            break;

                        case "Fahrenheit":
                        outputField.setText(String.valueOf(inputval - 459.67));
                            break;
                    
                        case "Kelvin":
                        outputField.setText(String.valueOf(inputval * 5.0/9.0));
                            break;

                        case "Rankine":
                        outputField.setText(String.valueOf(inputval));
                            break;

                        case "Reaumur":
                        outputField.setText(String.valueOf(((inputval - 491.67) * 4.0/9.0)));
                            break;

                        case "Delisle":
                        outputField.setText(String.valueOf(((671.67 - inputval) * 5.0/6.0)));
                            break;

                        case "Newton":
                        outputField.setText(String.valueOf((inputval - 491.67) * 11.0/60.0));
                            break;

                        case "Romer":
                        outputField.setText(String.valueOf(((inputval - 491.67) * 7.0/24.0 + 7.5)));
                            break;

                        default:
                            errorField.setText("Error : Invalid input!!");
                            break;
                    }
                    errorField.setText("Conversion successful!");
                    break;
                //Rankine case section end

                //Reaumur case section start
                case "Reaumur":
                    switch (choice_out) 
                    {
                        case "Celsius":
                        outputField.setText(String.valueOf(inputval * 5.0 / 4.0));
                            break;

                        case "Fahrenheit":
                        outputField.setText(String.valueOf((inputval * 9.0 / 4.0) + 32.0));
                            break;
                    
                        case "Kelvin":
                        outputField.setText(String.valueOf((inputval * 5.0 / 4.0) + 273.15));
                            break;

                        case "Rankine":
                        outputField.setText(String.valueOf((inputval * 9.0 / 4.0) + 491.67));
                            break;

                        case "Reaumur":
                        outputField.setText(String.valueOf(inputval));
                            break;

                        case "Delisle":
                        outputField.setText(String.valueOf((80.0 - inputval) * 15.0 / 8.0));
                            break;

                        case "Newton":
                        outputField.setText(String.valueOf(inputval * 33.0 / 80.0));
                            break;

                        case "Romer":
                        outputField.setText(String.valueOf(((inputval * 21.0 / 32.0) + 7.5)));
                            break;

                        default:
                            errorField.setText("Error : Invalid input!!");
                            break;
                    }
                    errorField.setText("Conversion successful!");
                    break;
                //Reaumur case section end

                //Delisle case section start
                case "Delisle":
                    switch (choice_out) 
                    {
                        case "Celsius":
                        outputField.setText(String.valueOf((100 - (inputval * 2.0 / 3.0))));
                            break;

                        case "Fahrenheit":
                        outputField.setText(String.valueOf((212 - (inputval * 6.0 / 5.0))));
                            break;
                    
                        case "Kelvin":
                        outputField.setText(String.valueOf((373.15 - (inputval * 2.0 / 3.0))));
                            break;

                        case "Rankine":
                        outputField.setText(String.valueOf((671.67 - (inputval * 6.0 / 5.0))));
                            break;

                        case "Reaumur":
                        outputField.setText(String.valueOf((80 - (inputval * 8.0 / 15.0))));
                            break;

                        case "Delisle":
                        outputField.setText(String.valueOf(inputval));
                            break;

                        case "Newton":
                        outputField.setText(String.valueOf((33 - (inputval * 11.0 / 50.0))));
                            break;

                        case "Romer":
                        outputField.setText(String.valueOf(( 60 - (inputval * 7.0 / 20.0))));
                            break;

                        default:
                            errorField.setText("Error : Invalid input!!");
                            break;
                    }
                    errorField.setText("Conversion successful!");
                    break;
                //Delisle case section end

                //Newton case section start
                case "Newton":
                    switch (choice_out) 
                    {
                        case "Celsius":
                        outputField.setText(String.valueOf((inputval * 100.0 / 33.0)));
                            break;

                        case "Fahrenheit":
                        outputField.setText(String.valueOf(((inputval * 60.0 / 11.0) + 32.0)));
                            break;
                    
                        case "Kelvin":
                        outputField.setText(String.valueOf(((inputval * 100.0 / 33.0) + 273.15)));
                            break;

                        case "Rankine":
                        outputField.setText(String.valueOf(((inputval * 60.0 / 11.0) + 491.67)));
                            break;

                        case "Reaumur":
                        outputField.setText(String.valueOf((inputval * 80.0 / 33.0)));
                            break;

                        case "Delisle":
                        outputField.setText(String.valueOf(((33.0 - inputval) * 50.0 / 11.0)));
                            break;

                        case "Newton":
                        outputField.setText(String.valueOf(inputval));
                            break;

                        case "Romer":
                        outputField.setText(String.valueOf((inputval * 35.0 / 22.0)));
                            break;

                        default:
                            errorField.setText("Error : Invalid input!!");
                            break;
                    }
                    errorField.setText("Conversion successful!");
                    break;
                //Newton case section end

                //Romer case section start
                case "Romer":
                    switch (choice_out) 
                    {
                        case "Celsius":
                        outputField.setText(String.valueOf(((inputval - 7.5) * 40.0 / 21.0)));
                            break;

                        case "Fahrenheit":
                        outputField.setText(String.valueOf(((inputval - 7.5) * 24.0 / 7.0 + 32.0)));
                            break;
                    
                        case "Kelvin":
                        outputField.setText(String.valueOf(((inputval - 7.5) * 40.0 / 21.0 + 273.15)));
                            break;

                        case "Rankine":
                        outputField.setText(String.valueOf(((inputval - 7.5) * 24.0 / 7.0 + 491.67)));
                            break;

                        case "Reaumur":
                        outputField.setText(String.valueOf(((inputval - 7.5) * 32.0 / 21.0)));
                            break;

                        case "Delisle":
                        outputField.setText(String.valueOf(((60.0 - inputval) * 20.0 / 7.0)));
                            break;

                        case "Newton":
                        outputField.setText(String.valueOf(((inputval - 7.5) * 22.0 / 35.0)));
                            break;

                        case "Romer":
                        outputField.setText(String.valueOf(inputval));
                            break;

                        default:
                            errorField.setText("Error : Invalid input!!");
                            break;
                    }
                    errorField.setText("Conversion successful!");
                    break;
                //Romer case section end               

                    default:
                    errorField.setText("Error : Invalid input!!");
                        break;
                }
            }
        });
        //Calculate Actionlistener section end

        //Swap Actionlistener section start
        swapButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                //Swap TextField values
                String tempInputVal=inputField.getText();
                inputField.setText(outputField.getText());
                outputField.setText(tempInputVal);

                //Swap ComboBox values
                String tempInputChoice=inputUnitChoice.getSelectedItem();
                inputUnitChoice.select(outputUnitChoice.getSelectedItem());
                outputUnitChoice.select(tempInputChoice);

                //Display conversion status
                errorField.setText("Swap successful!");
            }
        });
        //Swap Actionlistener section end

        //Frame initialization section start
        fr.setSize(380,400);
        fr.setLayout(null);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Frame initialization section end
    }
}
