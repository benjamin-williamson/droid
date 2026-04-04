---
title: "WGU Performance Assessment"
source: "https://tasks.wgu.edu/student/011610321/course/42420019/task/4121/overview"
author:
published:
created: 2026-04-01
description:
tags:
  - "clippings"
---
Competencies

---

4086.1.1: Creates Page Layouts

The learner creates page layouts with clean navigation.

4086.1.2: Designs Mobile Applications

The learner designs mobile application infrastructure and user interfaces.

4086.1.3: Develops Mobile Applications

The learner develops secure database-backed mobile applications in an object-oriented language. 

4086.1.4: Documents Solutions with Storyboards

The learner documents solutions for application requirements with storyboards and emulators.

4086.1.5: Articulates Development Process Challenges

The learner articulates challenges in the development process.

4086.1.6: Describes Alternative Methods to Problem-Solving

The learner describes alternative methods in overcoming mobile application development problems.

Introduction

---

As a competent mobile application developer, your understanding of mobile application structure and design will help you to develop applications to meet customer requirements. The following project to develop a vacation scheduler will allow you to demonstrate your ability to apply the skills you learned in the course in a familiar, real-world scenario.  
  
You will develop a multiple-screen mobile application for a traveler to track vacations and excursions. The application will allow students to enter, edit, and delete vacation and excursion data. It should provide a list and detailed views of vacations and excursions for each vacation and provide alerts for all the dates. This application will use the Room Framework as an abstraction layer over the local SQLite database.

Requirements

---

Your submission must represent your original work and understanding of the course material. Most performance assessment submissions are automatically scanned through the WGU similarity checker. Students are strongly encouraged to wait for the similarity report to generate after uploading their work and then review it to ensure Academic Authenticity guidelines are met before submitting the file for evaluation. See [Understanding Similarity Reports](https://cm.wgu.edu/t5/Frequently-Asked-Questions/Understanding-Similarity-Reports/ta-p/252) for more information.  
  
**Grammarly Note:**  
Professional Communication will be automatically assessed through Grammarly for Education in most performance assessments before a student submits work for evaluation. Students are strongly encouraged to review the Grammarly for Education feedback prior to submitting work for evaluation, as the overall submission will not pass without this aspect passing. See [Use Grammarly for Education Effectively](https://cm.wgu.edu/t5/Academic-Coaching-Center/Use-Grammarly-for-Education-Effectively/ta-p/52276) for more information.  
  
**Microsoft Files Note:**  
Write your paper in Microsoft Word (.doc or.docx) unless another Microsoft product, or pdf, is specified in the task directions. Tasks may not be submitted as cloud links, such as links to Google Docs, Google Slides, OneDrive, etc.  All supporting documentation, such as screenshots and proof of experience, should be collected in a pdf file and submitted separately from the main file. For more information, please see [Computer System and Technology Requirements.](https://cm.wgu.edu/t5/WGU-Student-Policy-Handbook/Computer-System-and-Technology-Requirements/ta-p/78)  
*  
You must use the rubric to direct the creation of your submission because it provides detailed criteria that will be used to evaluate your work. Each requirement below may be evaluated by more than one rubric aspect. The rubric aspect titles may contain hyperlinks to relevant portions of the course.  
*

  

*Note: The assessment must be submitted in an Android Studio project using Java as the programming language. External plugins and libraries are not allowed in the project.*

  

A. Create your subgroup and project by logging into GitLab using the web link provided and using the "GitLab How-To" web link, and do the following:

• Clone the project to the IDE.

• Commit with a message and push when you complete each of the tasks listed below (Prompts B1-5).  

*Note: You may commit and push whenever you want to back up your changes, even if a task is not complete.*  

• Submit a copy of the git repository URL and a copy of the repository branch history retrieved from your repository, which must include the commit messages and dates.  

*Note: Wait until you have completed all the following prompts before you create your copy of the repository branch history.*  

B. Create an Android mobile application, compatible with Android 8.0 and higher. The application must use the Room Framework as an abstraction layer over the local SQLite database to save the data. The application must include the following functional requirements:

1\. Create a user option to enter, update and delete vacations.

a. Allow the user to add as many vacations as desired.

b. Implement validation so that a vacation cannot be deleted if excursions are associated with it.  

*Note: The vacations and excursions are not pre-populated in the database, but are instead added by the user.*  

2\. Include the following details for *each* vacation:

• title (e.g., Bermuda Trip, Spring Break, London Trip)

• hotel or other place where you will be staying

• start date

• end date

3\. Include features that allow the user to do the following for *each* vacation:

a. Display a detailed view of the vacation, including all vacation details. This view can also be used to add and update the vacation information.

b. Enter, edit, and delete vacation information.

c. Include validation that the input dates are formatted correctly.

d. Include validation that the vacation end date is after the start date.

e. Include an alert that the user can set which will trigger on the start and end date, displaying the vacation title and whether it is starting or ending.

f. Include sharing features so the user can share all the vacation details via a sharing feature (either e-mail, clipboard or SMS) that automatically populates with the vacation details.

g. Display a list of excursions associated with *each* vacation.

h. Add, update, and delete as many excursions as needed.

4\. Include the following details for *each* excursion:

• The excursion title (e.g., Snorkeling, Hiking, Bus Tour, Cooking Lesson)

• The excursion date

5\. Include features that allow the user to do the following for *each* excursion:

a. Display a detailed view of the excursion, including the title, and date

b. Enter, edit, and delete excursion information.

c. Include validation that the input dates are formatted correctly.

d. Include an alert that the user can set that will trigger on the excursion date, stating the excursion title.

e. Include validation that the excursion date is during the associated vacation.  

*Note: If you do not commit with a message and push when you complete each of the tasks listed above, you will have to decompose their application to make the commits and pushes, even if it is already complete.*  

C. Design the application to include the following information, including appropriate GUI (graphical user interface) elements (e.g., navigation, input, and information) for *each* layout:

• home screen

• list of vacations

• list of excursions associated with a vacation

• detailed vacation view

• detailed excursion view  

D. Create a storyboard to demonstrate application flow that includes *each* of the menus and screens from part B.  

E. Provide screenshots of generating the signed APK to demonstrate that you have created a deployment package. Include the signed APK file with your submission.  

*Note: Verify that all the required functions of your application are working by executing the APK file. If the app is modified, regenerate the APK so it includes all the revisions*.  

F. Create a Readme file including:

• title and purpose of the application

• directions for how to operate the application and reach all the rubric aspects

• to which android version the signed APK is deployed

• a link to the git repository  

G. Demonstrate professional communication in the content and presentation of your submission.

File Restrictions

File name may contain only letters, numbers, spaces, and these symbols:! - \_. \* ' ( )  
File size limit: 200 MB  
File types allowed: doc, docx, rtf, xls, xlsx, ppt, pptx, odt, pdf, csv, txt, qt, mov, mpg, avi, mp3, wav, mp4, wma, flv, asf, mpeg, wmv, m4v, svg, tif, tiff, jpeg, jpg, gif, png, zip, rar, tar, 7z  

Rubric

---

A:GITLAB REPOSITORY

| **Not Evident**  A GitLab repository is not provided. | **Approaching Competence**  The subgroup and project are created in Gitlab, but the submission does not include *all* of the given requirements, or one or more of the given requirements contain errors. | **Competent**  The subgroup and project are created in GitLab correctly and the submission includes *each* of the given requirements. *Each* requirement is error-free. |
| --- | --- | --- |

B1:VACATION FUNCTIONAL REQUIREMENTS

| **Not Evident**  The mobile application does not allow the user to enter, update and delete vacations. | **Approaching Competence**  The mobile application does not use the Room Framework to allow the user to enter, update and delete vacations. The mobile application does not consistently store and retrieve submitted vacations or implement validation that prevents a vacation from being deleted if an excursion is associated. | **Competent**  The mobile application uses the Room Framework to allow the user to enter, update and delete vacations. The mobile application consistently stores and retrieves submitted vacations and implements validation that prevents a vacation from being deleted if an excursion is associated. |
| --- | --- | --- |

B2:VACATION DETAILS FEATURE

| **Not Evident**  The features included in the mobile application do not allow the user to add a title, hotel/ accommodation, or start and end date for each vacation. | **Approaching Competence**  The features included in the mobile application are coded to allow the user to add a title, hotel/ accommodation, or the start and end date for each vacation. | **Competent**  The features included in the mobile application are coded to allow the user to add a title, hotel/accommodation, and the start and end date for each vacation. |
| --- | --- | --- |

B3a:VACATION IMPLEMENTATION FEATURE

| **Not Evident**  The mobile application does not allow the user to see a detailed view of the vacation and to add and update the vacation information on this view. | **Approaching Competence**  The mobile application is coded so that the user can see a detailed view of the vacation or to add and update the vacation information on this view. | **Competent**  The mobile application is coded so that the user can see a detailed view of the vacation, and to add and update the vacation information on this view. |
| --- | --- | --- |

B3b:VACATION EDITING

| **Not Evident**  The mobile application does not allow the user to enter, edit, and delete vacation information. | **Approaching Competence**  The mobile application allows the user to enter, edit, or delete some vacation information. New or edited data is not consistently saved or retrieved. | **Competent**  The mobile application allows the user to enter, edit, and delete vacation information. All entered data is stored and retrieved from the database consistently and accurately. |
| --- | --- | --- |

B3c:DATE FORMATION VALIDATION

| **Not Evident**  The mobile application does not include validation that the input dates are formatted correctly. | **Approaching Competence**  The mobile application only includes validation that some input dates are formatted correctly. | **Competent**  The mobile application includes validation that all of the input dates are formatted correctly. |
| --- | --- | --- |

B3d:VACATION DATE VALIDATION

| **Not Evident**  The mobile application does not include validation that the vacation end date is after the start date. | **Approaching Competence**  The mobile application includes inconsistent validation that the vacation end date is after the start date. | **Competent**  The mobile application includes validation that the vacation end date is after the start date. |
| --- | --- | --- |

B3e:VACATION ALERT

| **Not Evident**  The mobile application does not include an alert that the user can set which will trigger on the start and end date, display the vacation title and whether it is starting or ending. | **Approaching Competence**  The mobile application includes an alert that is not able to be modified by the user, or does not trigger on both the start and end date, display the vacation title or whether it is starting or ending. | **Competent**  The mobile application includes an alert that the user can set which will trigger on the start and end date, display the vacation title and whether it is starting or ending. |
| --- | --- | --- |

B3f:SHARING FEATURES

| **Not Evident**  The mobile application does not include sharing features so the user can share all the vacation details via a sharing feature (either e-mail, clipboard or SMS) that automatically populates with the vacation details. | **Approaching Competence**  The mobile application includes some sharing features so the user can share all the vacation details via a sharing feature (either e-mail, clipboard or SMS) that automatically populates with the vacation details or includes sharing features, but they only prepopulate with some of the vacation details. | **Competent**  The mobile application includes sharing features so the user can share all the vacation details via a sharing feature (either e-mail, clipboard or SMS) that automatically populates with the vacation details. |
| --- | --- | --- |

B3g:EXCURSIONS

| **Not Evident**  The mobile application does not display a list of excursions associated with *each* vacation. | **Approaching Competence**  The mobile application displays a list of excursions, but does not filter the list by the vacation to which it is associated. | **Competent**  The mobile application displays a list of excursions associated with *each* vacation, and the data represents what was entered by the user. |
| --- | --- | --- |

B3h:EXCURSION EDITING

| **Not Evident**  The mobile application does not add, update and delete as many excursions as needed. | **Approaching Competence**  The mobile application can add, update or and delete a limited number of excursions or data storage and retrieval is inconsistent/inaccurate. | **Competent**  The mobile application can add, update and delete as many excursions as needed. |
| --- | --- | --- |

B4:EXCURSIONS FOR EACH VACATION

| **Not Evident**  The mobile application does not include the excursion title and date for *each* excursion. | **Approaching Competence**  The mobile application includes the excursion title or the date for *each* excursion. | **Competent**  The mobile application includes the excursion title and date for *each* excursion. |
| --- | --- | --- |

B5:INTERFACE REQUIREMENTS

| **Not Evident**  The mobile application does not include any of the given interface requirements. | **Approaching Competence**  The mobile application includes up to 4 of the given interface requirements. | **Competent**  The mobile application includes all 5 of the given interface requirements. |
| --- | --- | --- |

C:SCREEN LAYOUTS

| **Not Evident**  A design of any screen layouts is not provided. | **Approaching Competence**  The screen designs include the layout for each given screen, but not as described, or does not include appropriate GUI elements for each layout. | **Competent**  The screen designs include the layout for each given screen, as described, and includes appropriate GUI elements for each layout. |
| --- | --- | --- |

D:STORYBOARD

| **Not Evident**  A storyboard is not provided. | **Approaching Competence**  The storyboard demonstrates the flow of the mobile application but includes only some of the menus and screens from part B. | **Competent**  The storyboard demonstrates the flow of the mobile application and includes all of the menus and screens from part B. |
| --- | --- | --- |

E:SCREENSHOTS

| **Not Evident**  Screenshots are not provided. | **Approaching Competence**  The screenshots provided do not demonstrate the creation of a signed APK. | **Competent**  The screenshots provided demonstrate the creation of a signed APK. |
| --- | --- | --- |

F:README FILE

| **Not Evident**  The mobile application does not include any of the given Readme file requirements. | **Approaching Competence**  The mobile application includes up to 3 of the given Readme file requirements. | **Competent**  The mobile application includes all 4 of the given Readme file requirements. |
| --- | --- | --- |

G:[PROFESSIONAL COMMUNICATION](https://lrps.wgu.edu/provision/27641407 "https://lrps.wgu.edu/provision/27641407")

| **Not Evident**  This submission includes pervasive errors in professional communication related to grammar, sentence fluency, contextual spelling, or punctuation, negatively impacting the professional quality and clarity of the writing. Specific errors have been identified by Grammarly for Education under the Correctness category. | **Approaching Competence**  This submission includes substantial errors in professional communication related to grammar, sentence fluency, contextual spelling, or punctuation. Specific errors have been identified by Grammarly for Education under the Correctness category. | **Competent**  This submission includes satisfactory use of grammar, sentence fluency, contextual spelling, and punctuation, which promote accurate interpretation and understanding. |
| --- | --- | --- | 

Web Links

---

[GitLab How-To](https://cm.wgu.edu/t5/Frequently-Asked-Questions/Setting-up-an-Amazon-AWS-Environment/ta-p/50512 "GitLab How-To")

GitLab Instructions Knowledge Base Article

[GitLab](https://lrps.wgu.edu/provision/353990238 "GitLab")

Supporting Documents

---