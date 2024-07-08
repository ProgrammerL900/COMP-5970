# CPSC4970-Assignment-1a

This assignment has you performing basic git commands for adding, committing, branching, and working with remote repositories.  The grading will be based on the commit history and branches that are pushed to your Gitlab assignment 1a repository.

Do the follow:
# Basic Git Commands

1. Install git
   - Configure your username and email
   - Setup alias in .gitconfig for pretty print
    ```
    [alias]
       lg1 = log --graph --abbrev-commit --decorate --format=format:'%C(bold blue)%h%C(reset) - %C(bold green)(%ar)%C(reset) %C(white)%s%C(reset) %C(dim white)- %an%C(reset)%C(bold yellow)%d%C(reset)' --all
       lg2 = log --graph --abbrev-commit --decorate --format=format:'%C(bold blue)%h%C(reset) - %C(bold cyan)%aD%C(reset) %C(bold green)(%ar)%C(reset)%C(bold yellow)%d%C(reset)%n''          %C(white)%s%C(reset) %C(dim white)- %an%C(reset)' --all
       lg = !"git lg1"
    ```

2. Setup Gitlab Account
  - Generate ssh key on local system.  [How to](https://docs.gitlab.com/ee/user/ssh.html)
  - Add ssh key to account
3. Initialize a new git local repository by cloning M0 Assignment 1A remote repository to local git environment. Rather than copying below it is better if you copy the http url or ssh string from git lab "**Clone**" button on the main repository page. 

   - For http cloning you will need to replace "**\<gitlab username\>**" with your gitlab username (under profile):
    ```
    git clone https://<gitlab username>@gitlab.com/sec-sw-const-sum-24-b/<your project>/m0-assignment-1a.git
    ```
  - For ssh cloning after adding your public ssh key under your profile:
    ```
    git clone git@gitlab.com:sec-sw-const-sum-24-b/<your project>/m1-assigment-an.git
    ```
4. Create a **.gitignore** file.  
5. User **git status** to see files that are not added/tracked or committed 
6. Add and commit the **.gitignore** file.
7. Examine the git log after each commit.  Watch how the tree changes after every commit and how the HEAD (current place) changes.
    ```
    git lg
    git lg2
    ```
8. Let's sync our local changes to the remote repository.  Push local **main* changes to **main** branch on the remote repository on Gitlab. Examine Gitlab to make sure the file is present.
    ```
    git push origin
    ```
9. Create two branches name **feature-1** and **bug-1**

10. Add and commit a text file to each branch containing a quote from a movie.  File name can be the name of the movie.

11. Examine the git log after each commit.  Watch how the tree changes after every commit and how the HEAD changes.
    ```
    git lg
    git lg2
    ```
12. Switch to **main** branch and merge the branches
    ```
    git merge feature-1
    git merge bug-1
    ```
13. Push the changes to the Gitlab repository (origin).
    ```
    git push origin main
    ```
14. Examine the git log to notice how the origin/main has changed

# Working with Remotes

15. Push **feature-1** and **bug-1**  branches to the origin.  For branches you need first specify the remote tracking branches. Do the following for both branches
    ```
    git push -u origin <branch name>
             or
    git push --set-upstream origin <branch name>
    ```
16. Review on Gitlab that all branches are now present. Add another quote to each the file in **feature-1** and **bug-1** branch.  Add and Commit after each change.
17. Push changes from each branch to remote repository
    ```
    git push origin <branch>
         or
    git push origin   # for current branch
    ```
18. Create a pull request in Gitlab to merge branch into the main branch.
    - Assign yourself as the processor
19. Process the pull request
    - Review the changes by selecting the "Changes" tab at the top of the screen
    - Add a comment about the change
    - Merge the change in to main by selecting "Merge" button.
20. Pull merged changes into your local repository since it has changed.
    - Review git log
    - Switch to **main**
    - Pull remote changes down
    ```
    git pull origin
    ```
21. Create a branch of your choosing.  Add a few text files, modifying files after initial commits, thus ending have multiple commits. Push the branch to the remote repository.  Create a pull request and process it to have changes merged into **main** branch

Grading will be based on commit history reflecting completing the steps above and completed quiz.

