# Book Review Application

*Date :* 11 / 10 / 2022

*Author :* Mohamed "Guren" Nijadi

## ***Description :***

Java GUI application for setting up your own virtual library, managing your books list and review books as you finish reading them.

*Stack :*

* *IDE :* IntelliJ IDEA
* *Front-end :* JavaFX - Scene Builder
* *Back-end :* Java
* *RDBMS :* SQLite

### Project Structure

Following the Maven project structure, and setting up packages following the MVVM (Model View ViewModel) architectur

## Getting Started

### **prerequisites**

* javafx sdk
* [jackson](https://jar-download.com/artifacts/com.fasterxml.jackson.core)
* sqlite-jdbc

### **Usage**

The first contact with the application's interface, click on the profile button and insert information about yourself.

Profile changes are visualized after relaunching the app. (later changes for auto display).

In the search bar, you can insert a title for any book that you are looking for, but it may not show in the results because for demonstration purposes, I only picked a few results among the whole.

You can add any book that you chose from the appropriate add button, and to display the book in the app, you must refresh by clicking in the show all button.
For each book in your collection, you can open its interface and make changes (rating, review ...), click on submit for updating changes or delete for deleting the book.
Again you must refresh by clicking on show all (or any other display option).
Error messages are displayed in the console instead of popup windows (later changes for errors popup windows).

## Acknowledgments

Credits to [openlibrary](openlibrary.org) for their free public api, it is efficient and very simple to work with.
