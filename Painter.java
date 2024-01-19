import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.Checkbox;
import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.event.ItemListener;
import java.awt.Graphics;
import java.awt.BasicStroke;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.awt.Graphics2D;
import java.awt.Point;




public class Painter extends Applet{
        public static final int ERASER =0;
        public static final int RECTANGLE =1;
        public static final int OVAL = 2;
        public static final int LINE = 3;
        public static final int FREE =4;
        public static final int DOTT=5;
        int mode = 4;
        int current = 0;
        boolean filled = false;
        Color currColor = BLACK;
        boolean clearAllFlag = false;
        
        
	public ArrayList<Shape> shapes = new ArrayList<>();
        public ArrayList<Shape> trash = new ArrayList<>();
        
	public abstract class Shape{
            int x1, y1, x2, y2;
            boolean isFilled;
            Color color;
            ArrayList<Point> points = new ArrayList<>();
            
            public void draw(Graphics g){};
            public void fillDraw(Graphics g){};
            
            public Shape(){
            }
            
            public Shape(int x1, int y1, int x2, int y2){
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = y2;
                this.y2 = y2;
            }
        }
        
        public class Eraser extends Shape{
                public Eraser(int x1, int y1) {
                    super(x1, y1, x1, y1);
                }

                public Eraser() {     
                }

            @Override
            public void draw(Graphics g) {
                int[] x_arr = new int[points.size()];
                int[] y_arr = new int[points.size()];

                for (int i = 0; i < points.size(); i++) {
                    Point point = points.get(i);
                    x_arr[i] = point.x;
                    y_arr[i] = point.y; 
                }

                if (this.isFilled == false){
                    g.setColor(WHITE);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(50));
                    g2d.drawPolyline(x_arr, y_arr, points.size() - 1);
                    
                }
            }
            
            @Override
            public void fillDraw(Graphics g){
                int[] x_arr = new int[points.size()];
                int[] y_arr = new int[points.size()];

                for (int i = 0; i < points.size(); i++) {
                    Point point = points.get(i);
                    x_arr[i] = point.x;
                    y_arr[i] = point.y; 
                }

                if (this.isFilled == true){
                    g.setColor(WHITE);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(80));
                    g.drawPolyline(x_arr, y_arr, points.size() - 1);
                    
                }

            }
    }
        
        public class freeLine extends Shape{
                public freeLine(int x1, int y1) {
                    super(x1, y1, x1, y1);
                }
                public freeLine() {     
                }

            @Override
            public void draw(Graphics g) {
                int[] x_arr = new int[points.size()];
                int[] y_arr = new int[points.size()];

                for (int i = 0; i < points.size(); i++) {
                    Point point = points.get(i);
                    x_arr[i] = point.x;
                    y_arr[i] = point.y; 
                }

                if (this.isFilled == false){
                    g.setColor(this.color);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(1));
                    g.drawPolyline(x_arr, y_arr, points.size() - 1);
                    
                }
            }
            
            @Override
            public void fillDraw(Graphics g){
                int[] x_arr = new int[points.size()];
                int[] y_arr = new int[points.size()];

                for (int i = 0; i < points.size(); i++) {
                    Point point = points.get(i);
                    x_arr[i] = point.x;
                    y_arr[i] = point.y; 
                }

                if (this.isFilled == true){
                    g.setColor(this.color);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(5));
                    g.drawPolyline(x_arr, y_arr, points.size() - 1);
                    
                }

            }
    }
        
        public class dottedLine extends Shape{
                public dottedLine(int x1, int y1) {
                    super(x1, y1, x1, y1);
                }
                public dottedLine() {     
                }

            @Override
            public void draw(Graphics g) {
                int[] x_arr = new int[points.size()];
                int[] y_arr = new int[points.size()];

                for (int i = 0; i < points.size(); i++) {
                    Point point = points.get(i);
                    x_arr[i] = point.x;
                    y_arr[i] = point.y; 
                }

                if (this.isFilled == false){
                    g.setColor(this.color);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{5}, 0));
                    g.drawPolyline(x_arr, y_arr, points.size() - 1);
                    
                }
            }
            
            @Override
            public void fillDraw(Graphics g){
                int[] x_arr = new int[points.size()];
                int[] y_arr = new int[points.size()];

                for (int i = 0; i < points.size(); i++) {
                    Point point = points.get(i);
                    x_arr[i] = point.x;
                    y_arr[i] = point.y; 
                }

                if (this.isFilled == true){
                    g.setColor(this.color);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{5}, 0));
                    g.drawPolyline(x_arr, y_arr, points.size() - 1);
                    
                }

            }
    }
               
        public class Line extends Shape{
            public Line(int x1, int y1, int x2, int y2) {
                super(x1, y1, x2, y2);
                
            }

            public Line() {
            }

            @Override
            public void draw(Graphics g) {
                if (this.isFilled == false){
                    g.setColor(color);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(1));
                    g.drawLine(x1, y1, x2, y2);
                    
                }
            }
            
            @Override
            public void fillDraw(Graphics g){
                if (this.isFilled == true){
                    g.setColor(this.color);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setStroke(new BasicStroke(10)); 
                    g2d.drawLine(x1, y1, x2, y2);
                }
            }
        }
         
        public class Rectangle extends Shape{

            public Rectangle(int x1, int y1, int x2, int y2) {
                super(x1, y1, x2, y2);
                
            }

            public Rectangle() {
            }

            @Override
            public void draw(Graphics g) {
                if (this.isFilled == false){
                        g.setColor(this.color);
                        Graphics2D g2d = (Graphics2D) g;
                        g2d.setStroke(new BasicStroke(1));
                        g.draw3DRect(x1, y1,(x2-x1),(y2-y1), false);
                }
            }
            
            @Override
            public void fillDraw(Graphics g){
                if (this.isFilled == true){
                    g.setColor(this.color);
                    g.fillRect(x1, y1,(x2-x1), (y2-y1));
                }
            }
        }
        

        public class Oval extends Shape{

            public Oval(int x1, int y1, int x2, int y2) {
                super(x1, y1, x2, y2);
            }

            public Oval() {
            }

            @Override
            public void draw(Graphics g) {
                if (this.isFilled == false){
                        g.setColor(this.color);
                        Graphics2D g2d = (Graphics2D) g;
                        g2d.setStroke(new BasicStroke(1));
                        if(x2>x1 && y2>y1)g.drawOval(x1, y1,(x2-x1),(y2-y1));
                        else if(x2>x1 && y1>y2)g.drawOval(x1, y2,(x2-x1),(y1-y2));
                        else if(x1>x2 && y2>y1)g.drawOval(x2, y1,(x1-x2),(y2-y1));
                        else g.drawOval(x2, y2,Math.abs(x2-x1),Math.abs(y2-y1));
                    }
            }
            @Override
            public void fillDraw(Graphics g){
                if (this.isFilled == true){
                    g.setColor(this.color);
                    if(x2>x1 && y2>y1)g.fillOval(x1, y1,(x2-x1),(y2-y1));
                    else if(x2>x1 && y1>y2)g.fillOval(x1, y2,(x2-x1),(y1-y2));
                    else if(x1>x2 && y2>y1)g.fillOval(x2, y1,(x1-x2),(y2-y1));
                    else g.fillOval(x2, y2,Math.abs(x2-x1),Math.abs(y2-y1));
                }
            }
        }

        @Override
	public void init(){
		Button freeBtn = new Button("pencil");
                Button dotBtn = new Button("dotted pencil");
                Button rectBtn = new Button("rectangle");
                Button ovalBtn = new Button("circle");
                Button lineBtn = new Button("line");
                Button redBtn = new Button("red");
                Button blueBtn = new Button("blue");
                Button greenBtn = new Button("green");
                Checkbox fillBtn = new Checkbox("Fill", false);
                Button eraseBtn = new Button("Eraser");
                Button undo = new Button("Undo");
                Button redo = new Button("Redo");
                Button clearAll = new Button("Clear ALL");
		
                
                add(fillBtn);
				add(freeBtn);
                add(dotBtn);
                add(rectBtn);
				add(ovalBtn);
                add(lineBtn);
                add(redBtn);
                add(blueBtn);
                add(greenBtn);
                add(undo);
                add(redo);
                add(clearAll);
                add(eraseBtn);
                
		addMouseListener(new ClickListener());
		addMouseMotionListener(new DragListener());
                
                
                clearAll.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(clearAllFlag == false){
                            if (!shapes.isEmpty()) {
                                 for(Shape i : shapes){
                                     trash.add(i);
                                 }
                                 shapes.clear();
                                 clearAllFlag = true;
                                 mode = FREE;
                                 repaint();
                             }
                        }
                    }
                });
                
                redo.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!trash.isEmpty()) {
                                    shapes.add(trash.get(trash.size()-1));
                                    trash.remove(trash.size() - 1);
                                    if(current < shapes.size()){current = shapes.size()-1;}      
                        }                         
                       repaint();
                    }
		});
  
                
                undo.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clearAllFlag == true){
                            if (!trash.isEmpty()) {
                                 for(Shape i : trash){
                                     shapes.add(i);
                                 }
                                 trash.clear();
                                 clearAllFlag =false;
                                 current = trash.size(); 
                            } 
                        }
                        else if (!shapes.isEmpty()) {
                            trash.add(shapes.get(shapes.size()-1));
                            shapes.remove(shapes.size()-1);
                            if(current > 0){current = shapes.size()-1;}
                        }
                       repaint();
                    }
		});
                
                 
                eraseBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mode = ERASER;
                    }
		});
                dotBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mode = DOTT;
                    }
		});
                
                freeBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mode = FREE;
                    }
		});
                
                rectBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mode = RECTANGLE;
                    }
		});
                
                ovalBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mode = OVAL;
                    }
		});
                
                lineBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mode = LINE;
                    }
		});
                
                fillBtn.addItemListener(new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent e) {    
                        filled = fillBtn.getState();
                    }
                });
               
                redBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        currColor = RED;
                    }
                });
                
                blueBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        currColor = BLUE;
                    }
                });
                        
                greenBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        currColor = GREEN;
                    }
                });
                

	}
        @Override
	public void paint(Graphics g){
            if(!shapes.isEmpty()){
        	for (Shape i : shapes){
                    if(i.isFilled == false){
                        i.draw(g);
                    }
                    else if(i.isFilled == true){
                        i.fillDraw(g);
                    }    
                } 
        }
    }

	class ClickListener extends MouseAdapter{
                @Override
		public void mousePressed(MouseEvent e){   
                    if(clearAllFlag = true){trash.clear(); current = shapes.size();}
                    clearAllFlag =false;
                    switch (mode) {
                        case RECTANGLE:
                            shapes.add(new Rectangle());
                            shapes.get(current).color = currColor;
                            shapes.get(current).isFilled = filled;
                            shapes.get(current).x1 = e.getX();
                            shapes.get(current).y1 = e.getY();
                            break;
                        case OVAL:
                            shapes.add(new Oval());
                            shapes.get(current).color = currColor;
                            shapes.get(current).isFilled = filled;
                            shapes.get(current).x1 = e.getX();
                            shapes.get(current).y1 = e.getY();
                            break;
                        case LINE:
                            shapes.add(new Line());
                            shapes.get(current).color = currColor;
                            shapes.get(current).isFilled = filled;
                            shapes.get(current).x1 = e.getX();
                            shapes.get(current).y1 = e.getY();
                            shapes.get(current).x2 = e.getX();
                            shapes.get(current).y2 = e.getY();
                            break;
                        case DOTT:
                            shapes.add(new dottedLine());
                            shapes.get(current).color = currColor;
                            shapes.get(current).isFilled = filled;
                            shapes.get(current).points.add(e.getPoint());
                            shapes.get(current).points.add(e.getPoint());
                            break;
                        case FREE:
                            shapes.add(new freeLine());
                            shapes.get(current).color = currColor;
                            shapes.get(current).isFilled = filled;
                            shapes.get(current).points.add(e.getPoint());
                            shapes.get(current).points.add(e.getPoint());
                            break;
                        case ERASER:
                            shapes.add(new Eraser());
                            shapes.get(current).points.add(e.getPoint());
                            shapes.get(current).points.add(e.getPoint());
                            break;
                        default:
                            break;
                    }
                        
		}

                @Override
		public void mouseReleased(MouseEvent e){
                        current++;
                        repaint();
		}
	}
        
	class DragListener extends MouseAdapter{
                @Override
		public void mouseDragged(MouseEvent e){ 
                    repaint();
                    switch (mode) {
                        case RECTANGLE:
                            shapes.get(current).x2 = e.getX();
                            shapes.get(current).y2 = e.getY();
                            break;
                        case OVAL :
                            shapes.get(current).x2 = e.getX();
                            shapes.get(current).y2 = e.getY(); 
                            break;
                        case LINE:
                            shapes.get(current).x2 = e.getX();
                            shapes.get(current).y2 = e.getY(); 
                            break;
                        case FREE: 
                            shapes.get(current).points.add(e.getPoint());
                            shapes.get(current).points.add(e.getPoint());
                            break;
                        case DOTT: 
                            shapes.get(current).points.add(e.getPoint());
                            shapes.get(current).points.add(e.getPoint());
                            break;
                        case ERASER:
                            shapes.get(current).points.add(e.getPoint());
                            shapes.get(current).points.add(e.getPoint());
                            break;
                        default:
                            break;}
                }
        }
}
                        

