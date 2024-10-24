# SecureCoding_MiniProject
Project Overview
This project implements a Secure Login System developed in Java using the Swing framework for the GUI. The system allows users to sign up with their details (name, username, registration number, and password), log in using the provided credentials, and displays a welcome page upon successful authentication. The project adheres to basic secure coding principles and emphasizes user interaction in a simplified GUI environment.
Features
1. Sign-Up Page
•	Allows new users to register by entering their name, username, registration number, and password.
•	Input validation ensures that all fields are filled out before a user can register.
•	Registered users are stored in an in-memory list for future login purposes.
•	After successful registration, users can log in using the registered credentials.
2. Login Page
•	Provides an interface for users to input their username and password.
•	Validates the user’s credentials against the stored list of users from the sign-up process.
•	Upon successful login, the user is directed to a welcome page displaying their name and registration number.
•	If login fails, the system displays an error message.
3. Welcome Page
•	Displays a personalized welcome message showing the user’s name and registration number.
•	Provides an option to log out and exit the application.
System Design
The project utilizes Java Swing for building the user interface, with a GridBagLayout used to organize components on each form. The design ensures that the system is responsive and visually appealing, using consistent colors and font styles.
•	Sign-Up Form: The layout uses a white background with input fields aligned for a clear and user-friendly interface.
•	Login Form: A red background is used to create visual contrast, and the form includes simple login and cancel buttons.
•	Welcome Page: It features a red background with a bold welcome message and an exit button to close the application.
Secure Coding Practices
•	Passwords are collected through JPasswordField, ensuring they are masked during entry.
•	Validation checks ensure that all fields are filled before submission.
•	In-memory storage (List of User objects) is used for simplicity, but it can be extended to integrate with a database for scalability.
Classes Overview
1.	Signup: Handles user registration, including validation and storage of user details.
2.	Login: Authenticates users based on their registered credentials and handles successful or failed login attempts.
3.	Welcome: Displays a personalized greeting message and provides an option to exit the system.
How to Run
1.	Compile and run the Signup class, which opens the sign-up page.
2.	After registering, click the Login button to proceed to the login form.
3.	Enter the registered username and password on the login form to access the welcome page.
Future Improvements
•	Implement password encryption for secure storage.
•	Add error handling for edge cases.
•	Integrate a database for persistent user storage.

