import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

import java.nio.file.*;


class CinemaGUII {

    private int seatsbooked;
    public  static JLabel bookedLabel;

    public static JLabel availableLabel;


    public CinemaGUII() {
        JFrame frame=new JFrame("Cinema Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        BackgroundPanel panel = new BackgroundPanel(frame);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(JFrame frame) {
            backgroundImage = new ImageIcon("bg.jpg").getImage();
            setLayout(null);
            JButton button = new JButton("Watch Movie");
            button.setBounds(550, 10, 300, 60);
            button.setFont(new Font("Arial", Font.BOLD, 25));
            button.addActionListener(e-> {
                new WatchMovie();
                frame.dispose();
            });
            button.setBackground(Color.BLACK);
            button.setForeground(new Color(250, 249, 246));

            button.setFocusable(false);


            JButton button2 = new JButton("Booking");
            button2.setBounds(550, 80, 300, 60);
            button2.setFont(new Font("Arial", Font.BOLD, 25));
            button2.addActionListener(e-> {
                new movies();
                frame.dispose();
            });
            button2.setBackground(Color.BLACK);
            button2.setForeground(new Color(250, 249, 246));
            button2.setFocusable(false);

            JButton button3 = new JButton("Change Movie");
            button3.setBounds(550, 150, 300, 60);
            button3.setFont(new Font("Arial", Font.BOLD, 25));
            button3.setBackground(Color.BLACK);
            button3.setForeground(new Color(250, 249, 246));
            button3.setFocusable(false);
            button3.addActionListener(e-> {
                new changeMovies();
                frame.dispose();
            });

            JButton button4 = new JButton("Details");
            button4.setBounds(550, 220, 300, 60);
            button4.setFont(new Font("Arial", Font.BOLD, 25));
            button4.setBackground(Color.BLACK);
            button4.setForeground(new Color(250, 249, 246));
            button4.setFocusable(false);
            button4.addActionListener(e-> {
                new Details();
                frame.dispose();
            });
            add(button4);
            add(button);
            add(button2);
            add(button3);

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, 1400, 720, this);
        }
    }


    class changeMovies {
        public  changeMovies() {


            JFrame frame = new JFrame("MOVIES");
            frame.setLayout(new GridLayout(2, 2, 3, 3));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);



            JButton btnBackBooking = new JButton("←");
            btnBackBooking.setBounds(550, 320, 140, 30);
            btnBackBooking.setFocusable(false);
            btnBackBooking.setFont(new Font("Arial", Font.BOLD, 15));
            btnBackBooking.addActionListener(e-> {
                new CinemaGUII();
                frame.dispose();
            });

            for (int i = 0; i < 4; ++i) {
                String movie1 = Cinema.movies.get(i).name + ".jpg";
                ImageIcon image = new ImageIcon(movie1);
                int imgW  = 550;
                int imgH  = 350;
                ImageIcon scaledIcon = new ImageIcon(image.getImage().getScaledInstance(imgW, imgH, 0));
                int ii = i;
                JPanel p1=new JPanel();
                p1.setLayout(null);
                JLabel label = new JLabel();
                label.setBounds(0, 0, 750, imgH);
                label.setText("");
                label.setIconTextGap(0);
                label.setBackground(Color.black);
                label.setOpaque(true);
                label.setIcon(scaledIcon);
                JButton but=new JButton("Change");
                but.setFocusable(false);
                but.setFont(new Font("Arial", Font.BOLD, 15));
                but.addActionListener(e-> {
                    new replaceMovies(ii);
                    frame.dispose();

                });


                if(i != 3) {
                    but.setBounds(550, 0, 140, imgH );

                }
                else {
                    but.setBounds(550, 0, 140, 320);
                }
                p1.add(but);
                p1.add(btnBackBooking);
                p1.add(label);
                frame.add(p1);
                p1.setBackground(Color.BLACK);
            }

            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }

    }
    class WatchMovie {
        public  WatchMovie() {


            JFrame frame = new JFrame("MOVIES");
            frame.setLayout(new GridLayout(2, 2, 3, 3));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);



            JButton btnBackBooking = new JButton("←");
            btnBackBooking.setBounds(550, 320, 140, 30);
            btnBackBooking.setFocusable(false);
            btnBackBooking.setFont(new Font("Arial", Font.BOLD, 15));
            btnBackBooking.addActionListener(e-> {
                new CinemaGUII();
                frame.dispose();
            });

            for (int i = 0; i < 4; ++i) {
                String movie1 = Cinema.movies.get(i).name + ".jpg";
                ImageIcon image = new ImageIcon(movie1);
                int imgW  = 550;
                int imgH  = 350;
                ImageIcon scaledIcon = new ImageIcon(image.getImage().getScaledInstance(imgW, imgH, 0));
                int ii = i;
                JPanel p1=new JPanel();
                p1.setLayout(null);
                JLabel label = new JLabel();
                label.setBounds(0, 0, 750, imgH);
                label.setText("");
                label.setIconTextGap(0);
                label.setBackground(Color.black);
                label.setOpaque(true);
                label.setIcon(scaledIcon);
                JButton but=new JButton("Watch");
                but.setFocusable(false);
                but.setFont(new Font("Arial", Font.BOLD, 15));
                but.addActionListener(e-> playVideo(ii));


                if(i != 3) {
                    but.setBounds(550, 0, 140, imgH );

                }
                else {
                    but.setBounds(550, 0, 140, 320);
                }
                p1.add(but);
                p1.add(btnBackBooking);
                p1.add(label);
                frame.add(p1);
                p1.setBackground(Color.BLACK);
            }

            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }

    }
    class replaceMovies {
        JFrame frame = new JFrame("MOVIES");
        public  replaceMovies(int prev) {


            frame.setLayout(new GridLayout(2, 2, 3, 3));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);



            JButton btnBackBooking = new JButton("←");
            btnBackBooking.setBounds(550, 320, 140, 30);
            btnBackBooking.setFocusable(false);
            btnBackBooking.setFont(new Font("Arial", Font.BOLD, 15));
            btnBackBooking.addActionListener(e-> {
                new changeMovies();
                frame.dispose();
            });

            for (int i = 0; i < 4; ++i) {
                String movie1 = Cinema.movies2.get(i).name + ".jpg";
                ImageIcon image = new ImageIcon(movie1);
                int imgW  = 550;
                int imgH  = 350;
                ImageIcon scaledIcon = new ImageIcon(image.getImage().getScaledInstance(imgW, imgH, 0));
                int ii = i;
                JPanel p1=new JPanel();
                p1.setLayout(null);
                JLabel label = new JLabel();
                label.setBounds(0, 0, 750, imgH);
                label.setText("");
                label.setIconTextGap(0);
                label.setBackground(Color.black);
                label.setOpaque(true);
                label.setIcon(scaledIcon);
                JButton but=new JButton("Select");
                but.setFocusable(false);
                but.setFont(new Font("Arial", Font.BOLD, 15));
                but.addActionListener(e-> changeHandler(prev, ii));


                if(i != 3) {
                    but.setBounds(550, 0, 140, imgH );

                }
                else {
                    but.setBounds(550, 0, 140, 320);
                }
                p1.add(but);
                p1.add(btnBackBooking);
                p1.add(label);
                frame.add(p1);
                p1.setBackground(Color.BLACK);
            }

            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }
        void changeHandler(int prev, int next) {
            Movie temp = Cinema.movies.get(prev);
            Cinema.movies.set(prev, Cinema.movies2.get(next));
            Cinema.movies2.set(next, temp);
            new changeMovies();
            frame.dispose();

        }
    }
    public void playVideo(int i) {
        try {
            Path p = Paths.get("C:\\Program Files\\VideoLAN\\VLC\\vlc.exe");
            Path p1 = Paths.get(Cinema.movies.get(i).name  +".mp4");
            if(!Files.exists(p) || !Files.exists(p1)) {
                System.out.println("path not found");
                return;
            }
            ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\VideoLAN\\VLC\\vlc.exe", Cinema.movies.get(i).name  +".mp4");
            pb.start();

        }
        catch(IOException e) {
            System.out.println("Error");
        }
    }
    public void clickSeatHandling(int j) throws IOException {
        try {
            JFrame frame1 = new JFrame("Seats");

            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.setSize(800, 800);
            frame1.setLocationRelativeTo(null);
            frame1.setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 10));
            TextField tf = new TextField(10);
            String[] buttonlabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
            seatsbooked = 0;
            for (int i = 0; i < buttonlabels.length; i++) {
                String label = buttonlabels[i];
                JButton button = new JButton(label);
                button.setFont(new Font("Arial", Font.BOLD, 15));
                button.setFocusable(false);
                button.addActionListener(e->{
                    try {
                        clickSeatsHandler(e, j, tf);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                });
                boolean booked = false;
                ArrayList<Customer> customers= Cinema.readCustomers();
                for(int m = 0; m<customers.size(); ++m) {
                    if(customers.get(m).seatNo == i && customers.get(m).movie == j) {
                        booked = true;
                        seatsbooked++;
                    }
                }
                if(booked) {
                    button.setBackground(Color.RED);

                }
                else {
                    button.setBackground(Color.BLACK);
                }
                button.setForeground(Color.CYAN);
                panel.add(button);
            }

            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            panel1.setPreferredSize(new Dimension(800, 300));

            bookedLabel = new JLabel("Booked: " + seatsbooked);
            bookedLabel.setFont(new Font("Arial", Font.BOLD, 18));
            bookedLabel.setBackground(Color.BLACK);
            bookedLabel.setForeground(Color.WHITE);
            bookedLabel.setBounds(100, 100, 200, 20);
            bookedLabel.setOpaque(true);

            availableLabel = new JLabel("Available: " + (30 - seatsbooked));
            availableLabel.setFont(new Font("Arial", Font.BOLD, 18));
            availableLabel.setBackground(Color.BLACK);
            availableLabel.setForeground(Color.WHITE);
            availableLabel.setBounds(100, 130, 200, 20);
            availableLabel.setOpaque(true);

            JLabel tfLabel = new JLabel("NAME  " );
            tfLabel.setFont(new Font("Arial", Font.BOLD, 18));
            tfLabel.setBackground(Color.BLACK);
            tfLabel.setForeground(Color.WHITE);
            tfLabel.setBounds(350, 100, 200, 20);
            tfLabel.setOpaque(true);

            tf.setFont(new Font("Arial", Font.BOLD, 18));
            tf.setBackground(Color.BLACK);
            tf.setForeground(Color.WHITE);
            tf.setBounds(350, 130, 200, 25);

            JButton btnBackBooking = new JButton("←");
            btnBackBooking.setBounds(550, 200, 140, 30);
            btnBackBooking.setBackground(Color.BLACK);
            btnBackBooking.setForeground(Color.WHITE);
            btnBackBooking.setFocusable(false);
            btnBackBooking.setFont(new Font("Arial", Font.BOLD, 15));
            btnBackBooking.addActionListener(e-> {
                new movies();
                frame1.dispose();
            });

            panel1.add(tf);
            panel1.add(bookedLabel);
            panel1.add(availableLabel);
            panel1.add(tfLabel);
            panel1.add(btnBackBooking);
            frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame1.add(panel, BorderLayout.CENTER);
            frame1.add(panel1, BorderLayout.SOUTH);
            frame1.setVisible(true);

        }
        catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error");
        }
    }
    public void clickSeatHandling1(int j) throws IOException {
        try {
            JFrame frame1 = new JFrame("Seats");

            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame1.setSize(800, 800);
            frame1.setLocationRelativeTo(null);
            frame1.setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 10));

            String[] buttonlabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                    "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
            seatsbooked = 0;
            for (int i = 0; i < buttonlabels.length; i++) {
                String label = buttonlabels[i];
                JButton button = new JButton(label);
                button.setFont(new Font("Arial", Font.BOLD, 15));
                button.setFocusable(false);

                boolean booked = false;
                ArrayList<Customer> customers= Cinema.readCustomers();
                for(int m = 0; m<customers.size(); ++m) {
                    if(customers.get(m).seatNo == i && customers.get(m).movie == j) {
                        booked = true;
                        seatsbooked++;
                    }
                }
                if(booked) {
                    button.setBackground(Color.RED);

                }
                else {
                    button.setBackground(Color.BLACK);
                }
                button.setForeground(Color.CYAN);
                panel.add(button);
            }

            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            panel1.setPreferredSize(new Dimension(800, 300));

            bookedLabel = new JLabel("Booked: " + seatsbooked);
            bookedLabel.setFont(new Font("Arial", Font.BOLD, 18));
            bookedLabel.setBackground(Color.BLACK);
            bookedLabel.setForeground(Color.WHITE);
            bookedLabel.setBounds(100, 100, 200, 20);
            bookedLabel.setOpaque(true);

            availableLabel = new JLabel("Available: " + (30 - seatsbooked));
            availableLabel.setFont(new Font("Arial", Font.BOLD, 18));
            availableLabel.setBackground(Color.BLACK);
            availableLabel.setForeground(Color.WHITE);
            availableLabel.setBounds(100, 130, 200, 20);
            availableLabel.setOpaque(true);

            JButton btnBackBooking = new JButton("←");
            btnBackBooking.setBounds(550, 200, 140, 30);
            btnBackBooking.setBackground(Color.BLACK);
            btnBackBooking.setForeground(Color.WHITE);
            btnBackBooking.setFocusable(false);
            btnBackBooking.setFont(new Font("Arial", Font.BOLD, 15));
            btnBackBooking.addActionListener(e-> {
                new Details();
                frame1.dispose();
            });

            panel1.add(bookedLabel);
            panel1.add(availableLabel);
            panel1.add(btnBackBooking);
            frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame1.add(panel, BorderLayout.CENTER);
            frame1.add(panel1, BorderLayout.SOUTH);
            frame1.setVisible(true);
            for (java.awt.Component component : frame1.getContentPane().getComponents()) {
                component.setEnabled(false);
            }
        }
        catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("error");
        }
    }
    public void clickSeatsHandler(ActionEvent event, int j, TextField tf) throws IOException {
        JButton clickedButton = (JButton) event.getSource();
        if (clickedButton.getBackground() == Color.BLACK && !tf.getText().equals("")) {
            clickedButton.setBackground(Color.RED);
            int seat = Integer.parseInt(clickedButton.getText()) - 1;
            Cinema.writeCustomers(new Customer(tf.getText(), j, seat));
            seatsbooked++;
        }
        bookedLabel.setText("Booked: " + seatsbooked);
        availableLabel.setText("Available: " + (30 - seatsbooked));
    }

    class movies {
        public  movies() {


            JFrame frame = new JFrame("MOVIES");
            frame.setLayout(new GridLayout(2, 2, 3, 3));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);



            JButton btnBackBooking = new JButton("←");
            btnBackBooking.setBounds(550, 320, 140, 30);
            btnBackBooking.setFocusable(false);
            btnBackBooking.setFont(new Font("Arial", Font.BOLD, 15));
            btnBackBooking.addActionListener(e-> {
                new CinemaGUII();
                frame.dispose();
            });

            int i;
            for (i = 0; i < 4; ++i) {
                String movie1 = Cinema.movies.get(i).name + ".jpg";
                ImageIcon image = new ImageIcon(movie1);
                int imgW  = 550;
                int imgH  = 350;
                ImageIcon scaledIcon = new ImageIcon(image.getImage().getScaledInstance(imgW, imgH, 0));
                int ii = i;
                JPanel p1=new JPanel();
                p1.setLayout(null);
                JLabel label = new JLabel();
                label.setBounds(0, 0, 750, imgH);
                label.setText("");
                label.setIconTextGap(0);
                label.setBackground(Color.black);
                label.setOpaque(true);
                label.setIcon(scaledIcon);
                JButton but=new JButton("Trailer");
                JButton but1=new JButton("Seats");
                but.setFocusable(false);
                but.setFont(new Font("Arial", Font.BOLD, 15));
                but.addActionListener(e-> playVideo(ii));
                but1.setFont(new Font("Arial", Font.BOLD, 15));
                but1.setFocusable(false);
                but1.addActionListener(e-> {
                    try {
                        clickSeatHandling(ii);
                        frame.dispose();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                });

                if(i != 3) {
                    but.setBounds(550, 0, 140, imgH / 2);
                    but1.setBounds(550, imgH / 2, 140, imgH / 2);

                }
                else {
                    but.setBounds(550, 0, 140, 160);
                    but1.setBounds(550, 160, 140, 160);
                    p1.add(btnBackBooking);
                }
                p1.add(but);
                p1.add(but1);
                p1.add(label);
                frame.add(p1);
                p1.setBackground(Color.BLACK);
            }

            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }
    }


    class Details {
        public  Details() {


            JFrame frame = new JFrame("MOVIES DETAILS");
            frame.setLayout(new GridLayout(2, 2, 3, 3));
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);



            JButton btnBackBooking = new JButton("←");
            btnBackBooking.setBounds(550, 320, 140, 30);
            btnBackBooking.setFocusable(false);
            btnBackBooking.setFont(new Font("Arial", Font.BOLD, 15));
            btnBackBooking.addActionListener(e-> {
                new CinemaGUII();
                frame.dispose();
            });

            int i;
            for (i = 0; i < 4; ++i) {
                String movie1 = Cinema.movies.get(i).name + ".jpg";
                ImageIcon image = new ImageIcon(movie1);
                int imgW  = 550;
                int imgH  = 350;
                ImageIcon scaledIcon = new ImageIcon(image.getImage().getScaledInstance(imgW, imgH, 0));
                int ii = i;
                JPanel p1=new JPanel();
                p1.setLayout(null);
                JLabel label = new JLabel();
                label.setBounds(0, 0, 750, imgH);
                label.setText("");
                label.setIconTextGap(0);
                label.setBackground(Color.black);
                label.setOpaque(true);
                label.setIcon(scaledIcon);
                JButton but=new JButton("Customers Info");

                but.addActionListener(e-> {
                    try {
                        ArrayList<Customer> customers= Cinema.readCustomers();
                        System.out.println(Cinema.movies.get(ii).name);
                        for(int u = 0; u < customers.size(); ++u) {
                            if(customers.get(u).movie == ii) {
                                System.out.println("name :" + customers.get(u).name);
                                System.out.println("seat :" + customers.get(u).seatNo);
                                System.out.println();
                            }
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                });
                but.setFocusable(false);
                but.setFont(new Font("Arial", Font.BOLD, 15));

                JButton but1=new JButton("Seats Details");

                but1.addActionListener(e-> {
                    try {
                        clickSeatHandling1(ii);
                        frame.dispose();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                });
                but1.setFocusable(false);

                if(i != 3) {
                    but.setBounds(550, 0, 140, imgH / 2);
                    but1.setBounds(550, imgH / 2, 140, imgH / 2);

                }
                else {
                    but.setBounds(550, 0, 140, 160);
                    but1.setBounds(550, 160, 140, 160);
                    p1.add(btnBackBooking);
                }
                p1.add(but);
                p1.add(but1);
                p1.add(btnBackBooking);
                p1.add(label);
                frame.add(p1);
                p1.setBackground(Color.BLACK);
            }

            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }}

}

public class Main {

    public static void main(String[] args) throws IOException {
        new Cinema();
        new CinemaGUII();
    }
}
class Customer implements Serializable{
    public String name;
    public int movie;
    public int seatNo;
    Customer( String name,int movie,int seatNo) {
        this.name = name;
        this.movie = movie;
        this.seatNo = seatNo;
    }
}
class Movie {
    public String name;
    public int price;
    Movie(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
class Cinema {
    public static ArrayList<Customer> customers;
    public static ArrayList<Movie> movies = new ArrayList<Movie>();
    public static ArrayList<Movie> movies2 = new ArrayList<Movie>();
    Cinema() throws IOException {
        customers = readCustomers();
        movies.add(new Movie("The Lion King", 0));
        movies.add(new Movie("Zootopia", 0));
        movies.add(new Movie("Ice Age", 0));
        movies.add(new Movie("Madagascar", 0));
        movies2.add(new Movie("Tangled", 0));
        movies2.add(new Movie("Lorax", 0));
        movies2.add(new Movie("Ice Age Collision", 0));
        movies2.add(new Movie("The Croods", 0));
    }

    public static void writeCustomers(Customer obj) throws IOException  {
        ArrayList<Customer> object= Cinema.readCustomers();
        object.add(obj);
        if(object.size() == 0) {
            File myObj = new File("customers.txt");
            myObj.delete();
        }
        else {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("customers.txt"))) {
                objectOutputStream.writeObject(object);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Customer> readCustomers() throws IOException {
        ObjectInputStream objectInputStream = null;
        Path p = Paths.get("customers.txt");
        if(!Files.exists(p)) return new ArrayList<Customer>();
        ArrayList<Customer>  customers = null;
        try {
            objectInputStream = new ObjectInputStream(new
                    FileInputStream("customers.txt"));
            while (true) {
                customers = (ArrayList<Customer>) objectInputStream.readObject();
            }

        }
        catch (EOFException ignored) {
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
        objectInputStream.close();
        return customers;
    }
}