import javax.swing.*;

import AlarmClock.AdvancedAlarmClock;
import Watch.AdvancedWatch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JButton button_setTime;
    private JPanel mainPanel;
    private JSpinner spinner_hours;
    private JSpinner spinner_minutes;
    private JSpinner spinner_seconds;
    private JLabel label_time;
    private JSpinner spinner_alarmSeconds;
    private JSpinner spinner_alarmMinutes;
    private JSpinner spinner_alarmHours;
    private JButton button_pushAlarmClock;

    private AdvancedWatch watches;

    public MainWindow() {
        watches = new AdvancedWatch("MyWatch", 10);
        updateTimeLabel();

        button_setTime.addActionListener(e -> updateTime());
        button_pushAlarmClock.addActionListener(e -> pushAlarmClock());
    }

    public void updateTime() {
        try {
            watches.setHours((Integer) spinner_hours.getValue());
            watches.setMinutes((Integer) spinner_minutes.getValue());
            watches.setSeconds((Integer) spinner_seconds.getValue());
        } catch (Exception e) {
            return;
        }
        updateTimeLabel();
    }

    public void pushAlarmClock() {
        AdvancedAlarmClock alarmClock = new AdvancedAlarmClock();
        try {
            alarmClock.setAlarmHours((Integer) spinner_hours.getValue());
            alarmClock.setAlarmMinutes((Integer) spinner_minutes.getValue());
            alarmClock.setAlarmSeconds((Integer) spinner_seconds.getValue());
        } catch (Exception e) {
            return;
        }
        watches.pushAlarmClock(alarmClock);
    }

    public void updateTimeLabel() {
        label_time.setText(watches.toString());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Watches");
        frame.setContentPane(new MainWindow().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
