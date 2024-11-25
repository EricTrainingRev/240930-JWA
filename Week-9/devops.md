## DevOps
- Development Operations
- Hosting
- Set of practices/methodologies that are designed to make the development, deployment, and maintenance of code easier and more of a streamlined process
  - Usually involves some sort of automation
    - For example, when we see Jenkins, the pipeline will be automated (automatically test/build our project)
  - Structured Workflows
    - Set up pipeline files for Jenkins
  - Efficiency and Maintainability

## Steps in DevOps
1. Source Code Control - using some sort of VCS to manage the source code (typically in a repo like on Github)
2. Automation - automatically run tests when we make changes, make sure that the changes we make don't introduce any new bugs/issues with the code-base
  - Regression Testing - ensuring new bugs don't get introduced after new changes
3. Deployment to Staging - deploy/build the code to a temporary staging environment
4. Acceptance Testing - thinking like a user, performing tests with both valid and invalid input
  - Making sure that the user stories are adhered to
  - Can involve more integrated tests, testing systems together
5. Deployment of Build - migrate the build to a production environment where it is accessible by end-users. 

### DevOps vs Agile
- At first glance, DevOps and Agile might seem like they are different in a lot of ways
  - DevOps is a rigorous definition of the steps in code production
  - Agile is a more flexible methodology that allows us to re-iterate on past builds
- Keep in mind that both DevOps and Agile aim to make the coding process more efficient and streamlined

## CICD
- CICD - terms help to identify how much of our pipeline is automated
- Each "phase" builds off of the previous one
  - ex: we couldn't have continuous delivery if we didn't have continuous integration

### Continuous Integration
- Process of regularly merging code into a repository. Whenever we do make changes, ensure that the code "fits in"
- Pushing new code or merging code in as we go
- Utilize Github/Gitlab/Bitbucket
- Without Continuous Integration, we couldn't have Continuous Delivery/Deployment
- Benefits
  - Merge often, lower chance of merge conflicts
  - Essential for group projects where we need multiple people to work on the same code-base. We want to make sure that each team member always has the most up-to-date code
  - The more often we integrate our code, the less likely it is for merge conflicts to arise
    - Or, at the very least, the merge conflicts would be less severe
  - Identifying failures/bugs earlier on
- Goes up to step 2 in the [DevOps Steps](#steps-in-devops)

### Continuous Delivery
- Automating up to step 3 or 4
- Once our code is integrated and tested, we can move the build to a temporary environment where more testing can be done
  - Continuous Integration is a prerequisite for Continuous Delivery
- Can leave manual testing and final deployment as "manual", not automated
- Deployments can occur "at the push of a button"
- Benefits
  - Identify risks/failures in temporary environment as opposed to production
  - Predictable Progress - iterative builds, we can keep on tabs on what each build accomplishes and how far from our final goal

### Continuous Deployment
- At this point, every step is automated from source code control to deployment to production environment
- Prerequisites for Continuos Deployment are Continuous Integration and Continuous Delivery
- In theory, the most efficient since all of the steps are automated
  - However, pipeline, testing, and everything needs to be rigorously set up so that we're not introducing so many bugs to the application in production
  - Require rigorous communication between developers, testers, and DevOps engineers
- Final deployment is done automatically, not "at the push of a button"
- Benefits
  - More streamlined process
  - Customers or end-users will appreciate more frequent updates


### How to Automate
- Using a tool like Jenkins, we can automate the pipeline
- For example, after we push up code, we can set up pipelines to have the tests automatically trigger and not merge the code in if the tests fail
- Furthermore, if the initial round of tests pass, then we can automatically deploy the build to a temporary environment
  - More automatic tests can be run
  - Even some manual tests can be run here
- The final step of deploying to production can also be automated
  - If all the tests have passed and there are no other issues, automatically deploy these changes
  - Continuous Deployment is not always implemented, some pipelines might just use automation up to the Continuous Delivery stage and require manual intervention when it comes to deploying