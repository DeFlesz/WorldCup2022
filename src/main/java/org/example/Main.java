package org.example;

/*
TODO:
 [x] Ekran logawania i rejestracji (TabbedPane)
 [x] Abstrakja api (może singleton)
 [x] Obsługa rejestracji i logowania (UserModel, Controller)
 [] Zmień TeamListView żeby już w momencie landing page'a zebrać mecze i potem móc je poroździelać dla danej drużyny
 [] filtrowanie meczów
 [] wyświetlenie grup
 [] wybranie grupy którą chce się oglądać
 [] drabinka meczów (w api na szczęście są podanane etapy wystarczy pogłówkować)
 [] idk refactoring czy coś
 ----------------------------------------------------------
 [] zczytanie potrzebnych danych
 [x] Model meczu
 [x] model drużyny
 [] model grup
 [x] Wyświetlanie meczy
 [] obsługa filtrów itd
 __Wejście w szczegóły meczu__ <- nie da się sensownie, plus brak sensu
 [x] Wejście w szczegóły drużyny
 [] pokazanie rozegranych meczów dla drużyny
 */

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        AppFrame appFrame = new AppFrame();
    }

//    public static void main(String[] args) throws Exception {
////        System.out.println("Mundial!");

//
//        URL matchURL = new URL("http://api.cup2022.ir/api/v1/match");
//        HttpURLConnection matchConn = (HttpURLConnection) matchURL.openConnection();
//        matchConn.setRequestMethod("GET");
//        matchConn.setRequestProperty("Authorization", "Bearer "+dataObj2.get("token").toString());
//        matchConn.setRequestProperty("Content-type", "application/json");
//        String reply = "";
//        scanner = new Scanner(matchConn.getInputStream());
//        while (scanner.hasNext()){
//            reply += scanner.nextLine();
//        }
//        scanner.close();
//        JSONObject dataObj3 = new JSONObject(reply);
//        JSONArray arr = dataObj3.getJSONArray("data");
//
//        ArrayList<HashMap<String, String>> matches = new ArrayList<>();
//
//        for (int i = 0; i < arr.length(); i++) {
//            JSONObject O = arr.getJSONObject(i);
////            String string = O.get("home_team_en") + " " +
////                    O.get("home_score") + ":" +
////                    O.get("away_score") + " " +
////                    O.get("away_team_en");
//
//            HashMap<String, String> match = new HashMap<>();
//
//            match.put("host", ""+O.get("home_team_en"));
//            match.put("guest", ""+O.get("away_team_en"));
//            match.put("host_score", ""+O.get("home_score"));
//            match.put("guest_score", ""+O.get("away_score"));
//            match.put("host_flag", ""+O.get("home_flag"));
//            match.put("guest_flag", ""+O.get("away_flag"));
//
//            matches.add(match);
////            System.out.println(
////                    string
////            );
//        }
//
//        JFrame jFrame = new JFrame("Mundial");
//        jFrame.setSize(800, 600);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel panel = new JPanel();
//        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
//        panel.setLayout(new GridLayout(matches.size(), 5, 0, 10));
//
//        JLabel header = new JLabel("Mistrzostwa świata 2022:", SwingConstants.LEFT);
////        panel.add(new JLabel("a"));
////        panel.add(new JLabel("a"));
//
//
//        Set<String> countries = new TreeSet<>();
//        countries.add("all");
//
//        for (HashMap<String, String> map :
//                matches) {
//            if (map.get("host").contains("--") || map.get("guest").contains("--")) {
//                continue;
//            }
//
//            countries.add(map.get("host"));
//            countries.add(map.get("guest"));
//
//            JLabel hostLabel = new JLabel(map.get("host"));
//            JLabel scoreLabel = new JLabel(map.get("host_score") + " : " + map.get("guest_score"), SwingConstants.CENTER);
//            JLabel guestLabel = new JLabel(map.get("guest"), SwingConstants.RIGHT);
//
////            System.out.println(map.get("host_flag") + " " + map.get("guest_flag"));
//
//            URL hostFlagURL = new URL(map.get("host_flag"));
//            URLConnection hostConn = hostFlagURL.openConnection();
//            hostConn.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//            hostConn.connect();
//            InputStream hostURLStream = hostConn.getInputStream();
//
//
//            BufferedImage hostFlag = ImageIO.read(hostURLStream);
//            hostURLStream.close();
//
//            URL guestFlagURL = new URL(map.get("guest_flag"));
//            URLConnection guestConn = hostFlagURL.openConnection();
//            guestConn.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//            guestConn.connect();
//            InputStream guestURLStream = guestConn.getInputStream();
//
//            BufferedImage guestFlag = ImageIO.read(guestFlagURL);
//            guestURLStream.close();
//
//            ImageIcon hostFlagIcon = new ImageIcon(hostFlag);
//            JLabel hostFlagLabel = new JLabel(hostFlagIcon);
//
//            ImageIcon guestFlagIcon = new ImageIcon(guestFlag);
//            JLabel guestFlagLabel = new JLabel(guestFlagIcon);
//
//            panel.add(hostFlagLabel);
//            panel.add(hostLabel);
//            panel.add(scoreLabel);
//            panel.add(guestLabel);
//            panel.add(guestFlagLabel);
//        }
//
//        Container container = jFrame.getContentPane();
//
//        System.out.println(countries);
//        JComboBox comboBox = new JComboBox(countries.toArray());
//        comboBox.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        header.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        comboBox.addActionListener(l -> {
//            try {
//                populatePanel(matches,(String) comboBox.getItemAt(comboBox.getSelectedIndex()), panel);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
////        container.add(header);
////        container.add(panel);
//
//        JScrollPane scrollpane = new JScrollPane(panel);
//        jFrame.getContentPane().add(comboBox);
//        jFrame.getContentPane().add(scrollpane);
//
//        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
////        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
//
//        jFrame.setVisible(true);
////        ScrollPane scrollPane = new ScrollPane()
//
//        System.out.println(matches);
//    }
//
//    public static void populatePanel(ArrayList<HashMap<String, String>> matches, String country, JPanel panel) throws IOException {
//        panel.removeAll();
//
//        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
//        panel.setLayout(new GridLayout(matches.size(), 5, 0, 10));
//
//        for (HashMap<String, String> map :
//                matches) {
//            if (!(map.get("host").equals(country) || map.get("guest").equals(country))) {
//                continue;
//            }
//
//            if (map.get("host").contains("--") || map.get("guest").contains("--")) {
//                continue;
//            }
//
//            JLabel hostLabel = new JLabel(map.get("host"));
//            JLabel scoreLabel = new JLabel(map.get("host_score") + " : " + map.get("guest_score"), SwingConstants.CENTER);
//            JLabel guestLabel = new JLabel(map.get("guest"), SwingConstants.RIGHT);
//
////            System.out.println(map.get("host_flag") + " " + map.get("guest_flag"));
//
//            URL hostFlagURL = new URL(map.get("host_flag"));
//            URLConnection hostConn = hostFlagURL.openConnection();
//            hostConn.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//            hostConn.connect();
//            InputStream hostURLStream = hostConn.getInputStream();
//
//
//            BufferedImage hostFlag = ImageIO.read(hostURLStream);
//            hostURLStream.close();
//
//            URL guestFlagURL = new URL(map.get("guest_flag"));
//            URLConnection guestConn = hostFlagURL.openConnection();
//            guestConn.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//            guestConn.connect();
//            InputStream guestURLStream = guestConn.getInputStream();
//
//            BufferedImage guestFlag = ImageIO.read(guestFlagURL);
//            guestURLStream.close();
//
//            ImageIcon hostFlagIcon = new ImageIcon(hostFlag);
//            JLabel hostFlagLabel = new JLabel(hostFlagIcon);
//
//            ImageIcon guestFlagIcon = new ImageIcon(guestFlag);
//            JLabel guestFlagLabel = new JLabel(guestFlagIcon);
//
//            panel.add(hostFlagLabel);
//            panel.add(hostLabel);
//            panel.add(scoreLabel);
//            panel.add(guestLabel);
//            panel.add(guestFlagLabel);
//        }
//    }
}