package sardorbek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    JTextField name_field, mail_field;
    JRadioButton male, female;
    JCheckBox politic;

    public ContactForm() {
        super("Contact Form");
        super.setBounds(200, 100, 300, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 2));


        JLabel name = new JLabel("Введите свое имя: ");
        name_field = new JTextField("", 1);
        JLabel mail = new JLabel("Введите почту: ");
        mail_field = new JTextField("@", 1);
        male = new JRadioButton("Male", true);
        female = new JRadioButton("Female");
        politic = new JCheckBox("Politic");

        JButton enter = new JButton("Отправить");


        container.add(name);
        container.add(name_field);
        container.add(mail);
        container.add(mail_field);
        container.add(male);
        container.add(female);
        container.add(politic);
        container.add(enter);


        enter.addActionListener(new ButtonEventManager());
    }
    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText();
            String mail = mail_field.getText();

            String isMale = "Мужской";
            if (!male.isSelected() && female.isSelected()) {
                isMale = "Женский";
            } else if (male.isSelected() && !female.isSelected()) {
                isMale = "Мужской";
            } else {
                isMale = "Не указан";
            }

            boolean CheckBox = politic.isSelected();

            JOptionPane.showMessageDialog(null, "Ваша почта: " + mail + "\nВаш пол: " + isMale +
                    '\n' + "Вы согласны: " + CheckBox, "Привет " + name, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
