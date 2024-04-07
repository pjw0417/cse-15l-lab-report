cd example 1
![Image](cd with no argument.png)
absolute path: `/c/Users/Jungwoo Park/cse-15l-lab-report`
output: Using `cd` with no argument takes me to home directory `/c/Users/Jungwoo Park` by default.
This is because `cd` switches the current working directory to the given path and given path by default is `home`.
This is not an error.

cd example 2
![Image](cd directory.png)
absolute path: `/c/Users/Jungwoo Park`
output: Using `cd` with directory takes me from current working directory to argument directory `/c/Users/Jungwoo Park/cse-15l-lab-report` because `cd` switches the current working directory to the given path. My given path is `cse-15l-lab-report`. 
This is not an error.

cd example 3
![Image](cd file.png)
absolute path: `/c/Users/Jungwoo Park/cse-15l-lab-report`
output: Using `cd` with file gives an error message that `index.md: Not a directory`. 
This is because `cd` is used to change directory and file is not a directory.

ls example 1
![Image](ls with no argument.png)
absolute path: `/c/Users/Jungwoo Park/lecture1`
output: Using `ls` with no argument provides list of files and folders in `lecture1`. In `lecture 1` directory,
`messages` is only folder and rest of them are files. This is beacuse `ls` is used to list the files and folders in the given path. Since I didn't specify path, it provides files and folders in current directory of `lecture1`.
This is not an error. 

ls example 2
![Image](ls directory.png)
absolute path: `/c/Users/Jungwoo Park`
output: Using `ls` with directory lists provides lists of files and folders in `cse-15l-lab-report` directory.
In this directory, all of them are files. This is because `ls` is used to list the files and folders in the given path. The given path is `cse-15l-lab-report`. 
This is not an error.

ls example 3
![Image](cd file.png)
absolute path:`/c/Users/Jungwoo Park/cse-15l-lab-report`
output: Using `ls`with file displays the specified file if it exists, showing just the filename by default. 
In my case, it just shows `lab1.md`. This is because `ls` confirms that `lab1.md` exists in current directory.
This is not an error.

cat example 1
![Image](cat with no argument.png)
absolute path:`/c/Users/Jungwoo Park/cse-15l-lab-report`
output: Using `cat`with no argument doesn't provide anything unless I enter inputs and press enter. If I enter input like `abc`, it copies and prints my input `abc`. This is because `cat` is designed to read input and no file was given to read, so it just echos my input.
This is not an error.

cat example 2
![Image](cat directory.png)
absolute path:`/c/Users/Jungwoo Park`
output: Using `cat`with directory gives an error that `cse-15l-lab-report: Is a directory`. 
This is because cat reads files that have texts, but `cse-15l-lab-report` is a directory instead of file.

cat example 3
![Image](cat file.png)
absolute path:`/c/Users/Jungwoo Park/cse-15l-lab-report`
output: Using `cat`with file reads the texts inside my argument file. In this case,
`practice.md` provides `This is for practice!`. This is because `cat` prints the contents of one or more files with text and `practice.md` is a file that has texts.
This is not an error.


