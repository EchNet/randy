//
// Main.java
//

package net.ech.randy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Randy, main program.
 */
public class Main extends JFrame
{
    /**
     * Number of values displayed.
     */
    public final static int NVALUES = 5;

    // Instructions don't specify range of random numbers.  Make like dice.

    /**
     * Minimum displayed value.
     */
    public final static int MIN_VALUE = 1;

    /**
     * Maximum displayed value.
     */
    public final static int MAX_VALUE = 6;

    private RandomNumberGenerator randy;
    private JLabel[] labels;

    /**
     * Main function.  See package descriptor for instructions.
     */
    public static void main(String[] args)
    {
        try
        {
            Main application = new Main();

            if (args.length > 0)
            {
                Class clazz = Class.forName(args[0]);
                IRandomCore core = (IRandomCore) clazz.newInstance();
                application.setCore(core);
            }

            // User interface, version 1.0...
            //System.out.println(randy.nextInt(6) + " " +
                               //randy.nextInt(6) + " " +
                               //randy.nextInt(6) + " " +
                               //randy.nextInt(6) + " " +
                               //randy.nextInt(6));

            // Version 1.1.  How about a GUI?
            application.launch();
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
        }
    }

    /**
     * Constructor.
     */
    public Main()
    {
        randy = new RandomNumberGenerator();
        labels = new JLabel[NVALUES];
    }

    /**
     * Provide a new core for the RNG.
     */
    public void setCore(IRandomCore core)
    {
        randy.setCore(core);
    }

    /**
     * Show the GUI.
     */
    private void launch()
    {
        setTitle("RANDY");
        setSize(400, 150);

        Container content = getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new BorderLayout());
        content.add(createDisplay(), BorderLayout.CENTER);
        content.add(createButtonPanel(), BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    /**
     * Create the main display.
     */
    private JPanel createDisplay()
    {
        JPanel panel = new JPanel();

        for (int i = 0; i < labels.length; ++i)
        {
            JLabel label = new JLabel();
            label.setFont(new Font("Serif", Font.BOLD, 28));
            labels[i] = label;
            panel.add(label);
        }

        rollEm();

        return panel;
    }

    /**
     * Create the button panel.
     */
    private JPanel createButtonPanel()
    {
        JButton rollButton = new JButton(" ROLL ");
        rollButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                rollEm();
            }
        });

        JButton seedButton = new JButton(" RESEED ");
        seedButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                randy.setSeed(System.currentTimeMillis());
            }
        });

        JPanel panel = new JPanel();
        panel.add(rollButton);
        panel.add(seedButton);
        return panel;
    }

    /**
     * Roll new numbers and display them.
     */
    private void rollEm()
    {
        for (int i = 0; i < labels.length; ++i)
        {
            int nextValue = MIN_VALUE + randy.nextInt(MAX_VALUE - MIN_VALUE + 1);
            labels[i].setText(Integer.toString(nextValue)); 
        }
    }
}
