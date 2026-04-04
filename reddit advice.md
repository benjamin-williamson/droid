Here is a summary of the best advice from students on how to successfully and quickly complete the D308 Mobile Application Development course, along with critical technical details to keep in mind for the assessment.

### How to Move Through the Course Quickly

- **Speed up the webinars:** The primary resource for this course is a 4-part webinar series building a sample "Bicycle Shop" app. Many students found the videos painfully slow due to the instructor's computer lagging and crashing, so it is highly recommended to watch them at 1.5x to 2x speed and skip forward as needed.
- **Skip the videos if you have experience:** If you already have backend, database, and Git experience, you might find the videos too frustrating. You can save time by building the app from scratch using the rubric as your guide, referencing the completed Bicycle Shop source code from the GitLab templates only when you need a specific Android API example.
- **Test on a physical device:** Android Studio's virtual emulator is a massive memory hog that can slow down your computer. To speed up your testing process, enable USB debugging on a physical Android phone and use that to run and test your app instead.
- **Use ChatGPT for rubric clarification:** While you shouldn't use it to write your app, feeding the rubric to ChatGPT can help you quickly decode vague requirements, figure out DAO_Impl file changes, or strategize your development plan.

### Critical Setup Instructions

- **Proper Project Initialization:** The starter repo you clone from GitLab is essentially empty. To get the necessary Gradle dependencies, you must clone the empty repo to your computer, create a "working_branch", and then create a **brand new Empty Views Activity project** in Android Studio, making sure to save it in the exact same file path as your cloned repo.
- **Language Choices:** You can use Kotlin (which is recommended by Android Studio) or Groovy for your build configuration.

### Important Development Details to Keep in Mind

- **Translating the Webinar:** As you follow the video, remember that the webinar's "Product" is your "Vacation", and their "Part" is your "Excursion". You will also need to replace the double "price" variable used in the videos with a string for "hotel".
- **Handling Dates:** To save yourself a headache, store your start and end dates as Strings in the database (e.g., format `MM/dd/yy`). When it comes time to validate that an end date doesn't occur before a start date, use a `SimpleDateFormat` inside a `try/catch` block to parse the strings back into date objects for comparison.
- **Sharing Details:** The rubric requires you to share vacation details. Android intents only allow one `EXTRA_TEXT` payload, so you must concatenate all your vacation details and excursion lists into a single large String (using `\n` for line breaks) before sending it.
- **Alerts Not Showing:** If your validation alerts or notifications are not popping up, you likely need to go into the settings of your emulator or physical Android device and manually enable notifications for your specific app.
- **UI Formatting Issues:** Android Studio now enables `EdgeToEdge` by default, which can push your UI elements to the very top of the screen. You can fix this by commenting out `//EdgeToEdge.enable(this);` in your UI classes, or by adding `25dp` top/bottom margins and paying close attention to your layout constraints. Use scroll views so your app works in both horizontal and vertical orientations.

### Rubric and Submission Tips

- **Managing Commits:** The rubric requires specific commits for each task (B1, B2, C, etc.), which can be confusing because the requirements overlap heavily. Students note that the commit order doesn't strictly matter; you can code your app locally and make commits later, using dummy changes (like adding a space) just to generate the required commit messages (e.g., "B1: Added vacation list").
- **Storyboard:** Do this last. Take screenshots of your finished app running in the simulator and connect them using free tools like Canva, Whimsical, or Google Drive Drawings.
- **README File:** Ensure your README.md includes a step-by-step guide on how to use the app, explicitly calls out the rubric items you fulfilled, states that it is compatible with Android version 8.0, and includes a link to your GitLab repository.