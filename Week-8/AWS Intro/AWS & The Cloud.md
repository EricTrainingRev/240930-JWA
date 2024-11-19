# The Cloud
What do we mean by the cloud:
- a service/offering hosted on a computer belonging to someone else
- There are three primary offerings in the cloud
    - **Infrastructure as a Service (IaaS)**
        - this is the hardware that actually hosts the cloud service/resources
            - cloud providers such as AWS offering various regions you can host your applications/services in is an example of IaaS
    - **Platform as a Service (PaaS)**
        - this is the software that hosts your cloud service/resources
            - Elastic Cloud Compute (EC2) provided by AWS and Relational Database Service (RDS) are two examples of PaaS offered by AWS. 
    - **Software as a Service (SaaS)**
        - this is a fully fledge application/service offered in the cloud your team/company can integrate into their workflow
            - Jira and Salesforce are examples of SaaS: these services are hosted in the cloud (aka, someone elses computer/s) and we interface with them via the web. These applications are fully functioning, and we simply choose what feature we want to utilize for our purposes. We don't have to develop anything, but most SaaS offerings do provide a way to programatically customize the service 

# Amazon Web Services
A very profitable business venture by Amazon, AWS is one of the main cloud providers in the United States and across the world.

## Regions & Availability Zones
Locations where AWS has the physical computers to host their cloud offerings and user data are called "Regions". Inside each region there are multiple Availability Zones: these are the physical locations where the computers AWS owns are located and perform the hosting for the cloud offerings AWS has. Most regions will have multiple AZs to provide high levels of fault tolerance: if one AZ goes down the others can perform the hosting for the down AZ until it goes back up, and the extras can also store things like backups in case an AZ goes down

# Identity and Access Management
Any company working in the cloud has to determine who can access their cloud resources and what permissions they have with the cloud resources. AWS's Identity and Access Management (IAM) service provides a way for companies to control access to their cloud resources. IAM allows you to control access policies, users, and groups. Keep in mind, if you are a root user you have full permission to perform all actions, for better or worse, with your cloud resources
- **Access Policies**
    - these are actions for the various services AWS offers that can be used to control access and permissions  with those services. For instance, if you need your IT team to be able to create new virtual machines, but you need your development team to be able to access those machines, you would use access policies to allow the IT team to make the machines and the development team to interface with those machines
- **Users**
    - Users are cloud resources that have permissions to interact with one or more cloud service through assigned access policies.
- **Group**
    - instead of assigning individual access policies to users you can instead create a group, assign policies to the group, and then any users that are added to the group are given all of the permissions that are assigned to the group