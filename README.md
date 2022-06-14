# My Wardrobe - Organize your wardrobe

## 1. About

The target of our project was to create a desktop app that recreates a closet. The user has its own account and can manage the items in the wardrobe creating also outfit that combine different items. The search bar, a menu on the left of the homepage and the filters of the research allow the user to find the exact item he/she is looking for.

We wanted to create something that can be usefull to keep track of all items present in someone's wardrobe.

### 1.1. Demo

Add a link to a demo of your project.

## 2. Authors

This project was created by:

* Avezzù Irene 20142 
* Sacchetto Josephine 20464

## 3. Usage

Describe how to compile, package, and run your project here.

To build the project, run:

```shell
mvn package
```

To do X, run:

```
mvn abc
```

## 4. Implementation

...

### 4.1. Architectural Overview

We divided our idea in blocks structuring our application in classes
Describe the architecture of your application.

### 4.2. Third-Party Libraries

List and justify the third party libraries you used.

### 4.3. Programming Techniques

List and explain how you used the 10 programming techniques required for this project.
1.   **GUI:** We used JavaFX to realize the GUI
2.   **Logging:** each user has its own wardrobe so creating an account was a necessities and to allow more users on the seme devices logging becomed foundamental
3.   **I/O file:** we used file to obviate the absence of database, we used external text files to "remember" the past uses of the application. Files are also used to import items in a faster way compared to the manual option. In addition, file input are used to assign to each item a picture
4.   **Try/catch:** try and catch are necessary when working with I/O file
5.   **Abstract classes:** abstract classes were used in the realization of the Item class wich represent a general item but no item that is not a top/bottom/accesorize can be created
6.   **Generic method:** generic method were used to create an effective change method, so only one method was necessary. The T element can be of some specific type based on the instant data that the user wants to change
7.   **Overriding:** ?? to string di item
8.   **Overloading:** we used multiple constructor for the Item obj based on which parameters were passed
9.   **Varargs:** in AppPannel (per caricare gli oggetti)??
10.  **Generic classes:** ??

### 4.4. Tests

Briefly describe and motivate your test suite.

## 5. Experience

### 5.1. Overall Experience

The idea for this project came to us pretty easly but the realization did not come as easy. We wanted to creat something that could be actual useful. We intially struggled with the impossibility of using a database. The choice between a web app and a desktop us took us some times but at the end we choose a desktop app because it would be easier to upload picture of items for the users.
We did not manage the time given in the best way but by the end we were able to make it work.

### 5.2. Division of Responsibilities

Describe the roles and responsibilities each member had in this project. 

- **Irene Avezzù:** I was mainly responsible for the implementation of the backend section of the app
- **Josephine Sacchetto:** I was mainly responsible for the implementation of the frontend section of the app
- We worked separately in the actual realisazion of the code but the idea for both the  structure of the backend and the graphic of the frontend were discussed and realized together (50-50). Also when extra material were needed there was collaboration bothways. We also worked together for the realization of the test suits.


### 5.3. Main Challenges

Elaborate on the main challenges each group member faced throughout the project and how they were surpassed.

- **Irene Avezzù:** The most difficult aspect in this project for me was to implement xxx. The reason was X so I had to do Y and I achived Z.
- **Josephine Sacchetto:** The most difficult aspect in this project for me was to implement xxx. The reason was X so I had to do Y and I achived Z.

### 5.4. Learning Outcomes

Describe what you learned with this project.

- **Irene Avezzù** I learned a new library called `xyz`!
- **Josephine Sacchetto:** I learned how to implement the design pattern `abc`




