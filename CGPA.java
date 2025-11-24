import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;


class CGPA {
    private static String Gradepoint(double Grade){
        String Gradepoint;
        if (Grade >= 90)
            Gradepoint = "S";
        else if (Grade >= 80)
            Gradepoint = "A";
        else if (Grade >= 70)
            Gradepoint = "B";
        else if (Grade >= 60)
            Gradepoint = "C";
        else if (Grade >= 50)
            Gradepoint = "D";
        else if (Grade >= 40)
            Gradepoint = "E";
        else
            Gradepoint = "U";
        return Gradepoint;
    }
    private static String attendence(double attendance_percentage){
        String attendance;
        if (attendance_percentage >= 95)
            attendance = "H";
        else if (attendance_percentage >= 88)
            attendance = "9";
        else if (attendance_percentage >= 80)
            attendance = "8";
        else
            attendance = "L";
        return attendance;

    }
    private static double calculateCGPA(Scanner sc, int T){
        double totalSum = 0;

        for(int i=0; i<T; i++){
            System.out.println("Enter Subject  Name" + ":");
            String subjects = sc.next();

            System.out.println("Enter if "+ subjects + " has Endsem Practical (Yes/No/Project/online/NPTEL):");
            String endpractical = sc.next();

            if (endpractical.equalsIgnoreCase("Yes")){
                //Sessional Marks
                double average_sessional = 0;
                for (int j = 0; j < 2; j++) {
                    System.out.println("Enter sessional " + (j + 1) + " marks for " + subjects + " out of 100" + ":");
                    double se = sc.nextDouble();
                    double sessional_marks = se / 100 * 17.5;
                    average_sessional += sessional_marks;
                }
                System.out.println("Total Sessional Marks out of 35: " + average_sessional);

                //Midsem Check
                System.out.println("Enter Yes if " + subjects + " has midsem elesif (direct) else enter No:");
                String midsem_check = sc.next();

                if (midsem_check.equalsIgnoreCase("Yes")){
                    //Midsem Marks
                    double[] marks = new double[4];
                    String[] prompts = {"Midsem", "Regular Performance", "Endsem Theoretical", "Endsem Practical"};
                    double[] weights = {10, 5, 35, 15};

                    for(int n = 0; n < 4; n++) {
                        System.out.println("Enter " + prompts[n] + " marks for " + subjects + " out of 100:");
                        marks[n] = sc.nextDouble() / 100 * weights[n];
                    }
                    //Total CGPA calculation
                    double subjectTotal = average_sessional + marks[0] + marks[1] + marks[2] + marks[3];
                    System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                    totalSum += subjectTotal;

                    Gradepoint(subjectTotal);


                }else if (midsem_check.equalsIgnoreCase("no")){
                    double[] marks = new double[3];
                    String[] prompts = {"overall Regular Performance", "Endsem Theoretical", "Endsem Practical"};
                    double[] weights = {15, 35, 15};

                    for (int b = 0; b < 3; b++) {
                        System.out.println("Enter " + prompts[b] + " marks for " + subjects + " out of 100:");
                        marks[b] = sc.nextDouble() / 100 * weights[b];
                    }
                    //Total CGPA calculation
                    double subjectTotal = average_sessional + marks[0] + marks[1] + marks[2];
                    System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                    totalSum += subjectTotal;

                    Gradepoint(subjectTotal);

                } else {
                    System.out.println("Invallid input try again!");
                }

            }else if (endpractical.equalsIgnoreCase("No")){
                //Sessional Marks
                double average_sessional = 0;
                for (int j = 0; j < 2; j++) {
                    System.out.println("Enter sessional " + (j + 1) + " marks for " + subjects + " out of 100" + ":");
                    double se = sc.nextDouble();
                    double sessional_marks = se / 100 * 17.5;
                    average_sessional += sessional_marks;
                }
                System.out.println("Total Sessional Marks out of 35: " + average_sessional);

                // Midsem marks
                double[] marks = new double[2];
                String[] prompts = {"assessment", "performace marks"};
                double[] weights = {15, 50};
                for (int l = 0; l < 2; l++) {
                    System.out.println("Enter " + prompts[l] + " marks for " + subjects + " out of 100:");
                    marks[l] = sc.nextDouble() / 100 * weights[l];
                }
                //Total CGPA calculation
                double subjectTotal = average_sessional + marks[0] + marks[1];
                System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);

            }else if (endpractical.equalsIgnoreCase("Project")){
                //review marks
                double[] reviews = new double[3];
                String[] prompts = {"First Review", "Second Review", "Final Review"};
                double[] weights = {25, 25, 50};

                for (int a = 0; a < 3; a++) {
                    System.out.println("Enter " + prompts[a] + " marks for " + subjects + " out of 100:");
                    reviews[a] = sc.nextDouble() / 100 * weights[a];
                }
                //Total CGPA calculation
                double subjectTotal = reviews[0] + reviews[1] + reviews[2];
                System.out.println("Total CGPA for " + subjects + " is: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);

            }else if (endpractical.equalsIgnoreCase("online")){
                double[] internals = new double[5];
                String[] prompts = {"Internal marks", "Regular Laboratory Performance", "Mid Sem Practical", "Quiz", "Mini Project"};
                double[] weights = {20, 20, 15, 15, 30};

                for (int r = 0; r < internals.length; r++) {
                    System.out.println("Enter " + prompts[r] + " marks out of 100:");
                    double mark = sc.nextDouble();
                    internals[r] = mark / 100.0 * weights[r];
                    System.out.println("average marks:" + internals[r]);
                }
                double subjectTotal = internals[0] + internals[1] + internals[2] + internals[3] + internals[4];
                System.out.println("Average marks: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);

            }else if(endpractical.equalsIgnoreCase("NPTEL")){

                double[] nptel = new double[2];
                String[] prompts = {"assignment marks", "NPTEL Exam"};
                double[] weights = {25, 75};
                double[] vlaues = {0.25, 0.75};
                for (int z = 0; z < nptel.length; z++) {
                    System.out.println("Enter " + prompts[z] + " out of 100:");
                    double mark = sc.nextDouble();
                    double converstion = (mark / vlaues[z]);
                    nptel[z] = (converstion) / 100 * weights[z];
                    System.out.println(nptel[z]);
                }
                double subjectTotal = nptel[0] + nptel[1];
                System.out.println("Overall average is: " + subjectTotal);
                totalSum += subjectTotal;

                Gradepoint(subjectTotal);

            }else{
                System.out.println("Invalid Input");
            }
        }
        return totalSum / T;
    }
    // Attempt to call a local deep-learning prediction server.
    // Expects plain-text response with "label: value" lines. Returns empty string on failure.
    private static String tryDeepLearningServer(String imagePath) {
        File file = new File(imagePath);
        if (!file.exists() || !file.isFile()) {
            System.err.println("DL upload: image file not found: " + imagePath);
            return "";
        }

        String serverUrl = "http://localhost:5000/predict";
        String boundary = Long.toHexString(System.currentTimeMillis());
        String CRLF = "\r\n";
        HttpURLConnection connection = null;
        try {
            URL url = new URL(serverUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(15000);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            try (OutputStream output = connection.getOutputStream();
                 PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true)) {
                // file part
                writer.append("--" + boundary).append(CRLF);
                writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"").append(CRLF);
                writer.append("Content-Type: application/octet-stream").append(CRLF).append(CRLF).flush();
                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] buffer = new byte[4096];
                    int n;
                    while ((n = fis.read(buffer)) != -1) output.write(buffer, 0, n);
                    output.flush();
                }
                writer.append(CRLF).flush();
                writer.append("--" + boundary + "--").append(CRLF).flush();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("DL server responded with code: " + responseCode);
                return "";
            }
            StringBuilder resp = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) resp.append(line).append("\n");
            }
            return resp.toString();
        } catch (Exception e) {
            System.err.println("Error contacting DL server: " + e.getMessage());
            e.printStackTrace(System.err);
            return "";
        } finally {
            if (connection != null) connection.disconnect();
        }
    }

    // replace Tess4J OCR fallback with Tesseract CLI call; try common executable names and log errors
    private static String extractTextFromImage(String imagePath) {
        File file = new File(imagePath);
        if (!file.exists() || !file.isFile()) {
            System.err.println("OCR: image file not found: " + imagePath);
            return "";
        }

        // Try a list of possible tesseract commands
        String[] candidates = {
            "tesseract",
            "C:\\Program Files\\Tesseract-OCR\\tesseract.exe",
            "C:\\Program Files (x86)\\Tesseract-OCR\\tesseract.exe"
        };

        for (String cmd : candidates) {
            List<String> command = new ArrayList<>();
            command.add(cmd);
            command.add(imagePath);
            command.add("stdout");
            command.add("-l");
            command.add("eng");

            ProcessBuilder pb = new ProcessBuilder(command);
            pb.redirectErrorStream(true);
            StringBuilder output = new StringBuilder();
            try {
                Process p = pb.start();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                    String line;
                    while ((line = in.readLine()) != null) {
                        output.append(line).append("\n");
                    }
                }
                int rc = p.waitFor();
                if (rc == 0 && output.length() > 0) {
                    return output.toString();
                } else {
                    // try next candidate
                    // print minimal info for debugging
                    System.err.println("Tesseract candidate returned code " + rc + " for command: " + cmd);
                }
            } catch (IOException | InterruptedException e) {
                // try next candidate
                System.err.println("Failed to run tesseract command '" + cmd + "': " + e.getMessage());
            }
        }

        // If all attempts failed return empty string (caller will handle fallback)
        return "";
    }

    // parse label:number pairs from OCR/DL text into a map
    private static Map<String, Double> parseMarksFromText(String text) {
        Map<String, Double> map = new HashMap<>();
        if (text == null) return map;
        Pattern p = Pattern.compile("([A-Za-z\\s]+)[:\\-\\s]+(\\d{1,3}(?:\\.\\d+)?)");
        Matcher m = p.matcher(text);
        while (m.find()) {
            String label = m.group(1).trim().toLowerCase().replaceAll("\\s+", " ");
            try {
                double v = Double.parseDouble(m.group(2));
                map.put(label, v);
            } catch (NumberFormatException ignored) {}
        }
        return map;
    }

    // fetch value from map by trying several possible label keys; returns Double.NaN if missing
    private static double fetchFromMap(Map<String, Double> map, String... keys) {
        if (map == null) return Double.NaN;
        for (String k : keys) {
            String key = k.trim().toLowerCase().replaceAll("\\s+", " ");
            if (map.containsKey(key)) return map.get(key);
        }
        return Double.NaN;
    }

    // compute subject total using the same weight logic but read marks from parsed map
    private static double computeSubjectFromMap(String subject, String endpractical, boolean hasMidsem, Map<String, Double> map) {
        double subjectTotal = 0;
        if (endpractical.equalsIgnoreCase("Yes")) {
            // sessionals
            double avgSessional = 0;
            for (int j = 1; j <= 2; j++) {
                double raw = fetchFromMap(map, "sessional " + j, "sessional");
                if (Double.isNaN(raw)) raw = 0;
                avgSessional += raw / 100.0 * 17.5;
            }
            if (hasMidsem) {
                double mid = fetchFromMap(map, "midsem", "mid sem");
                double regular = fetchFromMap(map, "regular performance", "regular");
                double endTheo = fetchFromMap(map, "endsem theoretical", "endsem theoretical", "endsem theoritical", "endsem");
                double endPrac = fetchFromMap(map, "endsem practical", "endsem practical", "practical");
                mid = Double.isNaN(mid) ? 0 : mid; regular = Double.isNaN(regular) ? 0 : regular;
                endTheo = Double.isNaN(endTheo) ? 0 : endTheo; endPrac = Double.isNaN(endPrac) ? 0 : endPrac;
                subjectTotal = avgSessional + (mid/100.0*10) + (regular/100.0*5) + (endTheo/100.0*35) + (endPrac/100.0*15);
            } else {
                double regular = fetchFromMap(map, "overall regular performance", "regular performance", "regular");
                double endTheo = fetchFromMap(map, "endsem theoretical", "endsem");
                double endPrac = fetchFromMap(map, "endsem practical", "practical");
                regular = Double.isNaN(regular) ? 0 : regular; endTheo = Double.isNaN(endTheo) ? 0 : endTheo; endPrac = Double.isNaN(endPrac) ? 0 : endPrac;
                subjectTotal = avgSessional + (regular/100.0*15) + (endTheo/100.0*35) + (endPrac/100.0*15);
            }
        } else if (endpractical.equalsIgnoreCase("No")) {
            double avgSessional = 0;
            for (int j = 1; j <= 2; j++) {
                double raw = fetchFromMap(map, "sessional " + j, "sessional");
                if (Double.isNaN(raw)) raw = 0;
                avgSessional += raw / 100.0 * 17.5;
            }
            double assessment = fetchFromMap(map, "assessment", "assessment marks");
            double performance = fetchFromMap(map, "performance marks", "performance");
            assessment = Double.isNaN(assessment) ? 0 : assessment; performance = Double.isNaN(performance) ? 0 : performance;
            subjectTotal = avgSessional + (assessment/100.0*15) + (performance/100.0*50);
        } else if (endpractical.equalsIgnoreCase("Project")) {
            double r1 = fetchFromMap(map, "first review", "review 1", "review1");
            double r2 = fetchFromMap(map, "second review", "review 2", "review2");
            double r3 = fetchFromMap(map, "final review", "final");
            r1 = Double.isNaN(r1) ? 0 : r1; r2 = Double.isNaN(r2) ? 0 : r2; r3 = Double.isNaN(r3) ? 0 : r3;
            subjectTotal = (r1/100.0*25) + (r2/100.0*25) + (r3/100.0*50);
        } else if (endpractical.equalsIgnoreCase("online")) {
            String[] prompts = {"internal marks","regular laboratory performance","mid sem practical","quiz","mini project"};
            double[] weights = {20,20,15,15,30};
            double sum=0;
            for (int i=0;i<prompts.length;i++){
                double raw = fetchFromMap(map, prompts[i], prompts[i].replaceAll(" ", " "));
                raw = Double.isNaN(raw) ? 0 : raw;
                sum += raw/100.0*weights[i];
            }
            subjectTotal = sum;
        } else if (endpractical.equalsIgnoreCase("NPTEL")) {
            double a = fetchFromMap(map, "assignment marks", "assignment");
            double exam = fetchFromMap(map, "nptel exam", "nptel");
            a = Double.isNaN(a)?0:a; exam = Double.isNaN(exam)?0:exam;
            subjectTotal = (a/100.0*25) + (exam/100.0*75);
        } else {
            subjectTotal = 0;
        }
        return subjectTotal;
    }

    // GUI frames and main logic below
    static class SubjectInput {
        String name;
        String endPractical;
        boolean hasMidsem;
        String imagePath;
    }

    static class LoginFrame extends JFrame {
        LoginFrame() {
            setTitle("Login");
            setSize(320,180);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            JPanel p = new JPanel(new GridLayout(3,2,5,5));
            JLabel u = new JLabel("Username:");
            JTextField user = new JTextField();
            JLabel pass = new JLabel("Password:");
            JPasswordField pwd = new JPasswordField();
            JButton login = new JButton("Login");
            p.add(u); p.add(user); p.add(pass); p.add(pwd); p.add(new JLabel()); p.add(login);
            add(p);
            login.addActionListener(e -> {
                String un = user.getText().trim();
                String pw = new String(pwd.getPassword()).trim();
                if (un.equals("admin") && pw.equals("admin")) {
                    new UploadFrame().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials. Use admin/admin for demo.");
                }
            });
        }
    }

    static class UploadFrame extends JFrame {
        java.util.List<SubjectInput> inputs = new ArrayList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> subjList = new JList<>(listModel);

        UploadFrame() {
            setTitle("Upload Marks Papers");
            setSize(700,500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout(8,8));

            JPanel left = new JPanel(new BorderLayout(5,5));
            left.setPreferredSize(new Dimension(300,400));
            left.add(new JScrollPane(subjList), BorderLayout.CENTER);

            JPanel controls = new JPanel(new GridLayout(6,1,5,5));
            JTextField nameField = new JTextField();
            JComboBox<String> endPracBox = new JComboBox<>(new String[]{"Yes","No","Project","online","NPTEL"});
            JCheckBox midsemBox = new JCheckBox("Has Midsem");
            JButton chooseImage = new JButton("Choose Image");
            JLabel imgLabel = new JLabel("No file chosen");
            JButton addBtn = new JButton("Add Subject");
            controls.add(new JLabel("Subject Name:")); controls.add(nameField);
            controls.add(new JLabel("End Practical:")); controls.add(endPracBox);
            controls.add(midsemBox); controls.add(chooseImage);
            left.add(controls, BorderLayout.NORTH);
            left.add(imgLabel, BorderLayout.SOUTH);
            left.add(addBtn, BorderLayout.EAST);

            JButton compute = new JButton("Compute CGPA");
            JButton clear = new JButton("Clear All");

            JPanel right = new JPanel(new BorderLayout(5,5));
            JTextArea output = new JTextArea();
            output.setEditable(false);
            right.add(new JScrollPane(output), BorderLayout.CENTER);
            JPanel bottom = new JPanel();
            bottom.add(compute); bottom.add(clear);
            right.add(bottom, BorderLayout.SOUTH);

            add(left, BorderLayout.WEST); add(right, BorderLayout.CENTER);

            final String[] chosenPath = {null};
            chooseImage.addActionListener(e -> {
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileNameExtensionFilter("Images","jpg","jpeg","png"));
                int r = fc.showOpenDialog(this);
                if (r == JFileChooser.APPROVE_OPTION) {
                    chosenPath[0] = fc.getSelectedFile().getAbsolutePath();
                    imgLabel.setText(fc.getSelectedFile().getName());
                }
            });

            addBtn.addActionListener(e -> {
                String nm = nameField.getText().trim();
                if (nm.isEmpty()) { JOptionPane.showMessageDialog(this,"Enter subject name"); return; }
                SubjectInput si = new SubjectInput();
                si.name = nm;
                si.endPractical = (String) endPracBox.getSelectedItem();
                si.hasMidsem = midsemBox.isSelected();
                si.imagePath = chosenPath[0]; // may be null
                inputs.add(si);
                listModel.addElement(nm + " [" + si.endPractical + "] " + (si.imagePath==null ? "(no image)" : new File(si.imagePath).getName()));
                // reset
                nameField.setText(""); midsemBox.setSelected(false); imgLabel.setText("No file chosen"); chosenPath[0] = null;
            });

            clear.addActionListener(e -> {
                inputs.clear(); listModel.clear(); output.setText("");
            });

            compute.addActionListener(e -> {
                if (inputs.isEmpty()) { JOptionPane.showMessageDialog(this,"Add subjects first"); return; }
                output.setText("");
                double totalSum = 0;
                for (SubjectInput si : inputs) {
                    Map<String, Double> map = new HashMap<>();
                    if (si.imagePath != null) {
                        String dlResp = tryDeepLearningServer(si.imagePath);
                        if (!dlResp.isEmpty()) {
                            map = parseMarksFromText(dlResp);
                            output.append("Used DL server for " + si.name + "\n");
                        } else {
                            String ocrText = extractTextFromImage(si.imagePath);
                            map = parseMarksFromText(ocrText);
                            output.append("Used OCR for " + si.name + "\n");
                        }
                    } else {
                        output.append("No image for " + si.name + " — missing marks treated as 0\n");
                    }
                    double subjTotal = computeSubjectFromMap(si.name, si.endPractical, si.hasMidsem, map);
                    String gp = Gradepoint(subjTotal);
                    totalSum += subjTotal;
                    output.append(String.format("%s -> Total: %.2f  Grade: %s\n\n", si.name, subjTotal, gp));
                }
                double overall = totalSum / inputs.size();
                output.append(String.format("Overall CGPA (avg of totals): %.2f\n", overall));
            });
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}