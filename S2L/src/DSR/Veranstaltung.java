package DSR;

public class Veranstaltung {

// Instanzvariablen der XML Struktur
    //alles Strings: wegen dem JTable parsen und String Vergleich 
    //Ueberschrift
    private static int lasttabellennr = 0;
    private int tabellennr;
    private String semester;
    private String semText;
    private String ueberschriftID;
    private String uebene;
    private String ueberText;

    //Veranstaltungskern
    private String veranstNummer;
    private String vname;
    private String vNummer;
    private String vkurzel;
    private String vsws;
    private String vTyp;
    private String vdTyp;
    private String vHyper;
    private String vzSemester;
    private String druckVVZ;
    private String zuordBemerkung;

    //VZeit
    private String veranstterminVTID;
    private String veranstterminRGID;
    private String vzWoTag;
    private String vzWoTagKurz;
    private String vzBeginn;
    private String vzEnde;
    private String vzBeginnDat;
    private String vzEndeDat;
    private String vzRhyth;
    private String vzRhythmus;
    private String woTagKurz;
    private String vzBem;
    private String vzParallel;
    private int wochentagSort;

    //VZPerson
    private String veranstperPID;
    private String veranstperVTID;
    private String dozname;
    private String dozvorname;
    private String veranstperSort;

    //VZRaum
    private String raumName;
    private String raumForm;
    private String gebKTxt;

    //Rest_nicht zugewiesen
    private String bemerkung;
    private String literatur;
    private String anmerkung;
    private String kommentar;
    private String voraussetzung;
    private String nachweis;
    private String zugang;

    // Konstruktor der gesamten XML Struktur
    //#############################################
    public Veranstaltung(String semester, String semText, String ueberschriftID, String uebene, String ueberText,
            String veranstNummer, String vname, String vkurzel, String vsws, String vTyp, String vdTyp, String vHyper, String vzSemester, String druckVVZ, String zuordBemerkung,
            String veranstterminVTID, String veranstterminRGID, String vzWoTag, String vzWoTagKurz, String vzBeginn, String vzEnde, String vzBeginnDat, String vzEndeDat, String vzRhyth,
            String vzRhythmus, String woTagKurz, String vzBem, String vzParallel, int wochentagSort,
            String veranstperPID, String veranstperVTID, String dozname, String dozvorname, String veranstperSort,
            String raumName, String raumForm, String gebKTxt,
            String bemerkung, String literatur, String anmerkung, String kommentar, String voraussetzung, String nachweis, String zugang
    ) {

        this.setSemester(semester);
        this.setSemText(semText);
        this.setUeberschriftID(ueberschriftID);
        this.setUebene(uebene);
        this.setUeberText(ueberText);

        this.setVeranstNummer(veranstNummer);
        this.setVname(vname);
        this.setVkurzel(vkurzel);
        this.setVsws(vsws);
        this.setvTyp(vTyp);
        this.setVdTyp(vdTyp);
        this.setvHyper(vHyper);
        this.setVzSemester(vzSemester);
        this.setDruckVVZ(druckVVZ);
        this.setZuordBemerkung(zuordBemerkung);

        this.setVeranstterminVTID(veranstterminVTID);
        this.setVeranstterminRGID(veranstterminRGID);
        this.setVzWoTag(vzWoTag);
        this.setVzWoTagKurz(vzWoTagKurz);
        this.setVzBeginn(vzBeginn);
        this.setVzEnde(vzEnde);
        this.setVzBeginnDat(vzBeginnDat);
        this.setVzEndeDat(vzEndeDat);
        this.setVzRhyth(vzRhyth);
        this.setVzRhythmus(vzRhythmus);
        this.setWoTagKurz(woTagKurz);
        this.setVzBem(vzBem);
        this.setVzParallel(vzParallel);
        this.setWochentagSort(wochentagSort);

        this.setVeranstperPID(veranstperPID);
        this.setVeranstperVTID(veranstperVTID);
        this.setDozname(dozname);
        this.setDozvorname(dozvorname);
        this.setVeranstperSort(veranstperSort);

        this.setRaumName(raumName);
        this.setRaumForm(raumForm);
        this.setGebKTxt(gebKTxt);

        this.setBemerkung(bemerkung);
        this.setLiteratur(literatur);
        this.setAnmerkung(anmerkung);
        this.setKommentar(kommentar);
        this.setVoraussetzung(voraussetzung);
        this.setNachweis(nachweis);
        this.setZugang(zugang);

    }

    // Konstruktor f�r erforderliche mindest-Felder
    //#############################################                                           
    public Veranstaltung(String ueberText,
            String vname, String vkurzel, String vTyp, String vdTyp, String vzSemester,
            String vzWoTagKurz, String vzBeginn, String vzEnde, String vzBeginnDat, String vzEndeDat, String vzRhyth,
            String dozname,
            String raumName
    ) {

        this.semester = "Sommersemester 2016";
        this.semText = "Sommersemster 2016";
        this.ueberschriftID = "111";
        this.uebene = "1";
        this.ueberText = ueberText;

        this.veranstNummer = "55";
        this.vname = vname;
        this.vkurzel = vkurzel;
        this.vTyp = vTyp;
        this.vdTyp = vdTyp;
        this.vzSemester = vzSemester;
        this.druckVVZ = "J";

        this.veranstterminVTID = "1500";
        this.veranstterminRGID = "250";
        this.vzWoTag = "Mittwoch";
        this.vzWoTagKurz = vzWoTagKurz;
        this.vzBeginn = vzBeginn;
        this.vzEnde = vzEnde;
        this.vzBeginnDat = vzBeginnDat;
        this.vzEndeDat = vzEndeDat;
        this.vzRhyth = vzRhyth;
        this.vzRhythmus = "w�chentlich";
        this.wochentagSort = 3;

        this.veranstperPID = "111";
        this.veranstperVTID = "222";
        this.dozname = dozname;
        this.dozvorname = "leer";

        this.raumName = raumName;
        this.raumForm = "Vorlesungsram";
        this.gebKTxt = "FHG";

    }

    //Konstruktor zur Zeichenkette�bergabe  mit den mindest Feldern
    //#############################################
    public Veranstaltung(String zeile) {
        String s[] = zeile.split(";");

        this.semester = "Sommersemester 2016";
        this.semText = "Sommersemster 2016";
        this.ueberschriftID = "8761";
        this.uebene = "1";
        this.ueberText = s[0];

        this.veranstNummer = "55";
        this.vname = s[1];
        this.vNummer = "34";
        this.vkurzel = s[2];
        this.vTyp = s[3];
        this.vdTyp = s[4];
        this.vzSemester = s[5];
        this.druckVVZ = "J";

        this.veranstterminVTID = "1500";
        this.veranstterminRGID = "250";
        this.vzWoTag = "Mittwoch";
        this.vzWoTagKurz = s[6];
        this.vzBeginn = s[7];
        this.vzEnde = s[8];
        this.vzBeginnDat = s[9];
        this.vzEndeDat = s[10];
        this.vzRhyth = s[11];
        this.vzRhythmus = "w�chentlich";
        this.wochentagSort = 3;

        this.veranstperPID = "111";
        this.veranstperVTID = "222";
        this.dozname = s[12];
        this.dozvorname = "Helmut";

        if (s[13] != null) {
            this.raumName = s[13];
        } else {
            this.raumName = "0";
        }

        this.raumForm = "Vorlesungsram";
        this.gebKTxt = "FHG";

        this.tabellennr = lasttabellennr++;

    }

    // Getter und Setter - Methoden
    //#############################################
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSemText() {
        return semText;
    }

    public void setSemText(String semText) {
        this.semText = semText;
    }

    public String getUebene() {
        return uebene;
    }

    public void setUebene(String uebene) {
        this.uebene = uebene;
    }

    public String getUeberschriftID() {
        return ueberschriftID;
    }

    public void setUeberschriftID(String ueberschriftID) {
        this.ueberschriftID = ueberschriftID;
    }

    public String getUeberText() {
        return ueberText;
    }

    public void setUeberText(String ueberText) {
        this.ueberText = ueberText;
    }

    public String getVeranstNummer() {
        return veranstNummer;
    }

    public void setVeranstNummer(String veranstNummer) {
        this.veranstNummer = veranstNummer;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVkurzel() {
        return vkurzel;
    }

    public void setVkurzel(String vkurzel) {
        this.vkurzel = vkurzel;
    }

    public String getVsws() {
        return vsws;
    }

    public void setVsws(String vsws) {
        this.vsws = vsws;
    }

    public String getvTyp() {
        return vTyp;
    }

    public void setvTyp(String vTyp) {
        this.vTyp = vTyp;
    }

    public String getVdTyp() {
        return vdTyp;
    }

    public void setVdTyp(String vdTyp) {
        this.vdTyp = vdTyp;
    }

    public String getvHyper() {
        return vHyper;
    }

    public void setvHyper(String vHyper) {
        this.vHyper = vHyper;
    }

    public String getVzSemester() {
        return vzSemester;
    }

    public void setVzSemester(String vzSemester) {
        this.vzSemester = vzSemester;
    }

    public String getDruckVVZ() {
        return druckVVZ;
    }

    public void setDruckVVZ(String druckVVZ) {
        this.druckVVZ = druckVVZ;
    }

    public String getZuordBemerkung() {
        return zuordBemerkung;
    }

    public void setZuordBemerkung(String zuordBemerkung) {
        this.zuordBemerkung = zuordBemerkung;
    }

    public String getVeranstterminVTID() {
        return veranstterminVTID;
    }

    public void setVeranstterminVTID(String veranstterminVTID) {
        this.veranstterminVTID = veranstterminVTID;
    }

    public String getVeranstterminRGID() {
        return veranstterminRGID;
    }

    public void setVeranstterminRGID(String veranstterminRGID) {
        this.veranstterminRGID = veranstterminRGID;
    }

    public String getVzWoTag() {
        return vzWoTag;
    }

    public void setVzWoTag(String vzWoTag) {
        this.vzWoTag = vzWoTag;
    }

    public String getVzWoTagKurz() {
        return vzWoTagKurz;
    }

    public void setVzWoTagKurz(String vzWoTagKurz) {
        this.vzWoTagKurz = vzWoTagKurz;
    }

    public String getVzBeginn() {
        return vzBeginn;
    }

    public void setVzBeginn(String vzBeginn) {
        this.vzBeginn = vzBeginn;
    }

    public String getVzEnde() {
        return vzEnde;
    }

    public void setVzEnde(String vzEnde) {
        this.vzEnde = vzEnde;
    }

    public String getVzBeginnDat() {
        return vzBeginnDat;
    }

    public void setVzBeginnDat(String vzBeginnDat) {
        this.vzBeginnDat = vzBeginnDat;
    }

    public String getVzEndeDat() {
        return vzEndeDat;
    }

    public void setVzEndeDat(String vzEndeDat) {
        this.vzEndeDat = vzEndeDat;
    }

    public String getVzRhyth() {
        return vzRhyth;
    }

    public void setVzRhyth(String vzRhyth) {
        this.vzRhyth = vzRhyth;
    }

    public String getVzRhythmus() {
        return vzRhythmus;
    }

    public void setVzRhythmus(String vzRhythmus) {
        this.vzRhythmus = vzRhythmus;
    }

    public String getWoTagKurz() {
        return woTagKurz;
    }

    public void setWoTagKurz(String woTagKurz) {
        this.woTagKurz = woTagKurz;
    }

    public String getVzBem() {
        return vzBem;
    }

    public void setVzBem(String vzBem) {
        this.vzBem = vzBem;
    }

    public String getVzParallel() {
        return vzParallel;
    }

    public void setVzParallel(String vzParallel) {
        this.vzParallel = vzParallel;
    }

    public int getWochentagSort() {
        return wochentagSort;
    }

    public void setWochentagSort(int wochentagSort) {
        this.wochentagSort = wochentagSort;
    }

    public String getVeranstperPID() {
        return veranstperPID;
    }

    public void setVeranstperPID(String veranstperPID) {
        this.veranstperPID = veranstperPID;
    }

    public String getVeranstperVTID() {
        return veranstperVTID;
    }

    public void setVeranstperVTID(String veranstperVTID) {
        this.veranstperVTID = veranstperVTID;
    }

    public String getDozvorname() {
        return dozvorname;
    }

    public void setDozvorname(String dozvorname) {
        this.dozvorname = dozvorname;
    }

    public String getVeranstperSort() {
        return veranstperSort;
    }

    public void setVeranstperSort(String veranstperSort) {
        this.veranstperSort = veranstperSort;
    }

    public String getDozname() {
        return dozname;
    }

    public void setDozname(String dozname) {
        this.dozname = dozname;
    }

    public String getRaumName() {
        return raumName;
    }

    public void setRaumName(String raumName) {
        this.raumName = raumName;
    }

    public String getLiteratur() {
        return literatur;
    }

    public void setLiteratur(String literatur) {
        this.literatur = literatur;
    }

    public String getGebKTxt() {
        return gebKTxt;
    }

    public void setGebKTxt(String gebKTxt) {
        this.gebKTxt = gebKTxt;
    }

    public String getVoraussetzung() {
        return voraussetzung;
    }

    public void setVoraussetzung(String voraussetzung) {
        this.voraussetzung = voraussetzung;
    }

    public String getRaumForm() {
        return raumForm;
    }

    public void setRaumForm(String raumForm) {
        this.raumForm = raumForm;
    }

    public String getZugang() {
        return zugang;
    }

    public void setZugang(String zugang) {
        this.zugang = zugang;
    }

    public String getAnmerkung() {
        return anmerkung;
    }

    public void setAnmerkung(String anmerkung) {
        this.anmerkung = anmerkung;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getNachweis() {
        return nachweis;
    }

    public void setNachweis(String nachweis) {
        this.nachweis = nachweis;
    }

    public int getTabellennr() {
        return tabellennr;
    }

    public void setTabellennr(int tebellennr) {
        this.tabellennr = tebellennr;
    }

    public static void setLasttabellennr(int lasttabellennr) {
        Veranstaltung.lasttabellennr = lasttabellennr;
    }

    public String getvNummer() {
        return vNummer;
    }

    public void setvNummer(String vNummer) {
        this.vNummer = vNummer;
    }

}
