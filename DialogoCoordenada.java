import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogoCoordenada extends JDialog {
    private JTextField txtX, txtY;
    private JButton btnOk, btnCancelar;
    private Point resultado;
    private boolean ok = false;

    public DialogoCoordenada(Window owner) {
        super(owner, "Capturar coordenada", ModalityType.APPLICATION_MODAL);
        construirUI();
        configurarEventos();

        setSize(300, 250);
        setVisible(true);
    }

    private void construirUI() {
        JPanel panelCampos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCampos.add(new JLabel("X:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        txtX = new JTextField("0",10);
        panelCampos.add(txtX, gbc);

        // Fila 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelCampos.add(new JLabel("Y:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        txtY = new JTextField("0",10);
        panelCampos.add(txtY, gbc);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnOk = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnOk);
        panelBotones.add(btnCancelar);

        // Configuración del dialogo
        setLayout(new BorderLayout());
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        
    }

    private void configurarEventos() {
        // Gestión de Eventos
        btnOk.addActionListener(new OnOk());
        btnCancelar.addActionListener(new BotonCancelar());
        addWindowListener(new WinClose());
    }

    private class OnOk implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int x = Integer.parseInt(txtX.getText().trim());
                int y = Integer.parseInt(txtY.getText().trim());
                resultado = new Point(x, y);
                ok = true;
                dispose();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(
                    DialogoCoordenada.this,
                    "X y Y deben ser enteros",
                    "Dato inválido",
                    JOptionPane.ERROR_MESSAGE
            );                           
            }
        }
        
    }

    private class BotonCancelar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onCancel();
        }
    }

    private class WinClose extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            onCancel();
        }
        
    }

    private void onCancel() {
        ok = false;
        resultado = null;
        dispose();
    }

    public boolean isOk() {
        return ok;
    }

    public Point getResultado() {
        return resultado;
    }

    public static void main(String[] args) {
        DialogoCoordenada dialogo = new DialogoCoordenada(null);
        System.exit(0);
    }
}
