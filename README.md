# Book Review Application
<i>Date : </i>11 / 10 / 2022<br>
<i>Author : </i> Mohamed <q>Guren</q> Nijadi<br>
### <u><i><b>Description :</b></i></u><br>
Java GUI application for setting up your own virtual library, managing your books list and review books as you finish reading them.<br><br>
<b>Stack : </b>
<ul>
    <li><i>IDE :</i> IntelliJ IDEA</li>
    <li><i>Front-end :</i> JavaFX - Scene Builder</li>
    <li><i>Back-end :</i> Java</li>
    <li><i>RDBMS :</i> SQLite</li>
</ul>

### <u><i><b>Project Structure :</b></i></u><br>
Following the Maven project structure, and setting up packages following the MVVM (Model View ViewModel) architectur

## <i><b>Getting Started :</b></i><br>

#### prerequisites
<ul>
<li>javafx sdk</li>
<li>jackson: - <a>https://jar-download.com/artifacts/com.fasterxml.jackson.core</a></li>
<li>sqlite-jdbc</li>
</ul>

#### Usage
The first contact with the application's interface, click on the profile button and insert information about yourself.<br>
Profile changes are visualized after relaunching the app. (later changes for auto display).<br>
In the search bar, you can insert a title for any book that you are looking for, but it may not show in the results because for demonstration purposes, I only picked a few results among the whole.<br>
You can add any book that you chose from the appropriate add button, and to display the book in the app, you must refresh by clicking in the show all button.
For each book in your collection, you can open its interface and make changes (rating, review ...), click on submit for updating changes or delete for deleting the book.
Again you must refresh by clicking on show all (or any other display option).
Error messages are displayed in the console instead of popup windows (later changes for errors popup windows).

## Acknowledgments
I want to give credits to <a>openlibrary.org</a> for their free public api, it is efficient and very simple to work with.