package inputs;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener,  java.awt.event.MouseMotionListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        //código temporario, apenas para testes
        if (e.getButton() == MouseEvent.BUTTON1) {
        System.out.println("Botão esquerdo");
        }else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Botão direito");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
