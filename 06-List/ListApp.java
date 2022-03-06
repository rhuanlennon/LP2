class ListRect extends JFrame {
    ArrayList<Rect> rs = new ArrayList<Rect>();
    Random rand = new Random();

    ListRect () {
        this.addWindowListener ( 
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener( 
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'r') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        rs.add(new Rect(x,y, w,h));
                        repaint();
                    }
                }
            }
        );
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Rect r: this.rs) {
            r.paint(g);
        }

    }
}
