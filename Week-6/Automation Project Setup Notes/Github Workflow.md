# Automation Project Github Workflow

## Setup
- create repo
- create branch protection rules
    - target your main branch (main will be default, targeting either works)
    - set "require a pull request before merging" rule
        - this will require everyone to push their changes to a dev branch and then make a pull request via github to merge their changes in to main
        - this is a proven practice to help protect your main branch from application breaking
         changes, and it makes it easier to handle any merge conflicts when they arise 
    - set 1 or 2 required reviewers for your pull requests
    - set "block force pushes" to prevent anyone from using the force flag to push changes directly to the main branch

## Work
- decide upon branching strategy
    - how will you name your branches?
    - how often do you perform commits?

### General Work Flow
- make a pull request on your main branch
    - always start your work with this action
    - ```git pull```
- make your development branch
    - ```git switch -c {branch name}```
- do your work, make sure to commit your work as decided on when designing your branch strategy
    - if you pause work and come back to it later, make a pull request on the main branch and merge any changes into your dev branch
- push your work to the remote repo
    - ``` git push --set-upstream origin {branch name}``` if creating the remote branch
    - ```git push``` if the remote has already been created
- make a pull request in Github
    - get one more people to review the request
- once the request is merged in to main, either delete the branch or continue work

