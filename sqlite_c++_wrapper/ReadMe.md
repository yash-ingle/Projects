# How to Use
## Introduction to SQLite C++ Wrapper
Managing data efficiently is crucial for any software application, and SQLite is a popular choice for developers due to its lightweight and easy-to-use nature. However, working directly with SQLite's C API can be challenging, especially for C++ developers.

The SQLite C++ Wrapper is here to simplify that process. This library provides a straightforward and user-friendly interface for interacting with SQLite databases in C++. By wrapping the complexities of the SQLite API, it allows developers to focus on building their applications without getting lost in low-level details.

With features like automatic memory management and easy integration with C++ data types, the SQLite C++ Wrapper makes it easier than ever to work with databases. Whether you're creating a small project or a larger application, this wrapper will help you manage your data efficiently and effectively. Dive in and see how the SQLite C++ Wrapper can enhance your development experience!

## SQLite C++ Wrapper
*For Windows Users (Setup)*
- Open command prompt and go to the `src` folder.
- Run `createLibrary.bat`. (If everything is fine, it will generate `sqliteWrapper.lib` file)

*For Linux Users (Setup)*
- Open terminal and go to the `src` folder.
- Run `chmod +x createLibrary.sh` and `dos2unix createLibrary.sh`.
- Run `./createLibrary.sh` (If everything is fine, it will generate `libsqliteWrapper.a` file)


### Create the Library

Build the SQLite C++ wrapper library and add it to your project.

<img src="https://github.com/yash-ingle/Projects/blob/main/sqlite_c%2B%2B_wrapper/screenshots/sqlite_c%2B%2B_wrapper_1.png">

### Use the Library
Include the library in your application and perform database CRUD operations:

- **Create** records
- **Retrieve** records
- **Update** records
- **Delete** records

<img src="https://github.com/yash-ingle/Projects/blob/main/sqlite_c%2B%2B_wrapper/screenshots/sqlite_c%2B%2B_wrapper_2.png">

<img src="https://github.com/yash-ingle/Projects/blob/main/sqlite_c%2B%2B_wrapper/screenshots/sqlite_c%2B%2B_wrapper_3.png">

<img src="https://github.com/yash-ingle/Projects/blob/main/sqlite_c%2B%2B_wrapper/screenshots/sqlite_c%2B%2B_wrapper_4.png">

<img src="https://github.com/yash-ingle/Projects/blob/main/sqlite_c%2B%2B_wrapper/screenshots/sqlite_c%2B%2B_wrapper_5.png">

<img src="https://github.com/yash-ingle/Projects/blob/main/sqlite_c%2B%2B_wrapper/screenshots/sqlite_c%2B%2B_wrapper_6.png">

> **Note:** Refer to the `sqlite_c++_wrapper/testcases/demo_test_cases` folder for sample **Create**, **Insert**, **Select**, **Update**, and **Delete** implementations. These examples show how to use the library in your own projects.
