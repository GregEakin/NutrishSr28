/*
 * Copyright (c) 2017. Greg Eakin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.gdbtech.dao.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DATA_SRC")
public class DataSource {
    private String DataSrc_ID;  // Unique ID identifying the reference/source.
    private String Authors;     // List of authors for a journal article or name of sponsoring organization for other documents.
    private String Title;       // Title of article or name of document, such as a report from a company or trade association.
    private String Year;        // Year article or document was published.
    private String Journal;     // Name of the journal in which the article was published.
    private String Vol_City;    // Volume number for journal articles, books, or reports; city where sponsoring organization is located.
    private String Issue_State; // Issue number for journal article; State where the sponsoring organization is located.
    private String Start_Page;  // Starting page number of article/document.
    private String End_Page;    // Ending page number of article/document.
    private Set<NutrientData> nutrientDataSet = new HashSet<>(0);

    //  Links to Nutrient Data file by NDB No. through the Sources of Data Link file

    @Id
    @Column(name = "DataSrc_ID", length = 6, nullable = false)
    public String getDataSrc_ID() {
        return DataSrc_ID;
    }

    public void setDataSrc_ID(String dataSrc_ID) {
        DataSrc_ID = dataSrc_ID;
    }

    @Column(name = "Authors", length = 255)
    public String getAuthors() {
        return Authors;
    }

    public void setAuthors(String authors) {
        Authors = authors;
    }

    @Column(name = "Title", length = 255, nullable = false)
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Column(name = "Year", length = 4)
    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    @Column(name = "Journal", length = 135)
    public String getJournal() {
        return Journal;
    }

    public void setJournal(String journal) {
        Journal = journal;
    }

    @Column(name = "Vol_City", length = 16)
    public String getVol_City() {
        return Vol_City;
    }

    public void setVol_City(String vol_City) {
        Vol_City = vol_City;
    }

    @Column(name = "Issue_State", length = 5)
    public String getIssue_State() {
        return Issue_State;
    }

    public void setIssue_State(String issue_State) {
        Issue_State = issue_State;
    }

    @Column(name = "Start_Page", length = 5)
    public String getStart_Page() {
        return Start_Page;
    }

    public void setStart_Page(String start_Page) {
        Start_Page = start_Page;
    }

    @Column(name = "End_Page", length = 5)
    public String getEnd_Page() {
        return End_Page;
    }

    public void setEnd_Page(String end_Page) {
        End_Page = end_Page;
    }

    @ManyToMany(mappedBy = "dataSourceSet")
    public Set<NutrientData> getNutrientDataSet() {
        return nutrientDataSet;
    }

    public void setNutrientDataSet(Set<NutrientData> nutrients) {
        this.nutrientDataSet = nutrients;
    }
}
