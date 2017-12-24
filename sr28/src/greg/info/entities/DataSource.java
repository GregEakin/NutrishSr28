package greg.info.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DATA_SRC")
public class DataSource {
    @Id
    @Column(name = "DataSrc_ID", columnDefinition = "character(6)", nullable = false, unique = true)
    private String DataSrc_ID;  // Unique ID identifying the reference/source.

    @Column(name = "Authors", columnDefinition = "varchar(6)")
    private String Authors;     // List of authors for a journal article or name of sponsoring organization for other documents.

    @Column(name = "Title", columnDefinition = "varchar(255)", nullable = false)
    private String Title;       // Title of article or name of document, such as a report from a company or trade association.

    @Column(name = "Year", columnDefinition = "character(4)")
    private String Year;        // Year article or document was published.

    @Column(name = "Journal", columnDefinition = "varchar(135)")
    private String Journal;     // Name of the journal in which the article was published.

    @Column(name = "Vol_City", columnDefinition = "character(16)")
    private String Vol_City;    // Volume number for journal articles, books, or reports; city where sponsoring organization is located.

    @Column(name = "Issue_State", columnDefinition = "character(5)")
    private String Issue_State; // Issue number for journal article; State where the sponsoring organization is located.

    @Column(name = "Start_Page", columnDefinition = "character(5)")
    private String Start_Page;  // Starting page number of article/document.

    @Column(name = "End_Page", columnDefinition = "character(5)")
    private String End_Page;    // Ending page number of article/document.

    //  Links to Nutrient Data file by NDB No. through the Sources of Data Link file
    @ManyToMany
    @JoinTable(name = "DATSRCLN", joinColumns = {@JoinColumn(name = "DataSrc_ID")}, inverseJoinColumns = {@JoinColumn(name = "NDB_No"), @JoinColumn(name = "Nutr_No")})
    private Set<NutrientData> nutrients;

    public String getDataSrc_ID() {
        return DataSrc_ID;
    }

    public void setDataSrc_ID(String dataSrc_ID) {
        DataSrc_ID = dataSrc_ID;
    }

    public String getAuthors() {
        return Authors;
    }

    public void setAuthors(String authors) {
        Authors = authors;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getJournal() {
        return Journal;
    }

    public void setJournal(String journal) {
        Journal = journal;
    }

    public String getVol_City() {
        return Vol_City;
    }

    public void setVol_City(String vol_City) {
        Vol_City = vol_City;
    }

    public String getIssue_State() {
        return Issue_State;
    }

    public void setIssue_State(String issue_State) {
        Issue_State = issue_State;
    }

    public String getStart_Page() {
        return Start_Page;
    }

    public void setStart_Page(String start_Page) {
        Start_Page = start_Page;
    }

    public String getEnd_Page() {
        return End_Page;
    }

    public void setEnd_Page(String end_Page) {
        End_Page = end_Page;
    }

    public Set<NutrientData> getNutrients() {
        return nutrients;
    }

    public void setNutrients(Set<NutrientData> nutrients) {
        this.nutrients = nutrients;
    }
}
