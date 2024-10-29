# Behavior Driven Development
When doing Agile development, such as a Scrum, there are many entities with varied understanding of business needs and technical knowledge, and there is often a correlation between how a higher level of one leads to a lower level of the other (high tech knowledge, low understanding of business needs, vice versa). A way to help all parties understand what an application needs to do, and how it accomplishes those needs, is through Behavior Driven Development (BDD)

In BDD, development is guided primarily by the user perspective. This means thinking like an end user and imagining how they engage with the product you are working on. This is a good first step in getting the stakeholders and development team on the same page

The language used to help the stakeholders and development team reach a shared understanding is called "user stories". These are statements that describe the following:
- who/what is performing an action
- what action is being performed
- why the action is being performed

The structure of a user story follows a typical pattern:
- As a... (actor)
- I want... (action)
- So that... (expected result)

These three components, actor, action, expected result, are all entities that are easier for both stakeholders and developers to understand than subjects like KPIs and APIS. Typically you want your User Stories to be specific

- Good User Story: As a Customer I want to log in to my account so I can earn points on my coffee purchases
    - a good user story is specific about the actor, action, and expected result
- Not So Good User Story: As a Customer I want to access my account so I can benefit from my actions with the service
    - a less useful user story will have vague details and leave much to the imagination regarding actor actions and desired results

User stories provide a good starting point for stakeholders and developers to better share their understanding of the requirements for the product, but it is not enough. The next step after determining User Stories is to figure out the "Acceptance Criteria" for those user stories. When used with User Stories, acceptance criteria tends to follow specific "scenarios" for the User Story. For instance, if you have the following user story:"As a Customer I want to log in to my account so I can earn points on my cafe purchases for future rewards". At this stage of training we should be able to think of at least two test scenarios. The first being positive, valid credentials should let the customer log in, and negative, invalid credentials do not let the user log in. In this example, we would have two potential "Scenarios" for our User Story that would require Acceptance Criteria:
- Scenario One: Login Success
- Scenario Two: Login Fail

In order to organize these Scenarios and their Acceptance Criteria, a common syntax for this is called "Gherkin". This syntax has some standardized ways of organizing User Stories and associating Acceptance Criteria with those User Stories in a resource called a "Feature File". See [Example Feature File](Example%20Feature%20File.feature) for more detailed notes