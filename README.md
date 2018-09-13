# cdss-lib-dmi-hydrobase-rest-java #

This repository contains Colorado's Decision Support Systems (CDSS) Java library for
the State of Colorado's HydroBase REST web services.

Eclipse is used for development and repositories currently contain Eclipse project files to facilitate
setting up the Eclipse development environment.
Development on library code usually occurs while developing an application such as TSTool,
rather than the library alone, because software requirements come from application development.

This software is being migrated to an open source software project as part of the OpenCDSS project.
See the following online resources:

* [CDSS](http://cdss.state.co.us)
* [OpenCDSS](http://learn.openwaterfoundation.org/cdss-website-opencdss/)
* [Colorado Division of Water Resources REST Web Services](https://dnrweb.state.co.us/DWR/DwrApiService/Help)
* [TSTool Developer Documentation](http://learn.openwaterfoundation.org/cdss-app-tstool-doc-dev/) - example of application that uses this library

The developer documentation and guidelines will be updated as the development environment is used in development.  See the following sections in this page:

* [Repository Folder Structure](#repository-folder-structure)
* [Repository Dependencies](#repository-dependencies)
* [Development Environment Folder Structure](#development-environment-folder-structure)
* [Testing](#testing)
* [Version](#version)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)

--------

## Repository Folder Structure ##

The following are the main folders and files in this repository, listed alphabetically.
See also the [Development Environment Folder Structure](#development-environment-folder-structure)
for overall folder structure recommendations.

```
cdss-lib-dmi-hydrobase-rest-java/  Source code and development working files.
  .classpath                       Eclipse configuration file.
  .git/                            Git repository folder (DO NOT MODIFY THIS except with Git tools).
  .gitattributes                   Git configuration file for repository.
  .gitignore                       Git configuration file for repository.
  .project                         Eclipse configuration file.
  bin/                             Eclipse folder for compiled files (dynamic so ignored from repo).
  conf/                            Configuration files for installer build tools.
  dist/                            Folder used to build distributable installer (ignored from repo).
  lib/                             Third-party libraries.
  LICENSE.txt                      Library license file.
  README.md                        This file.
  src/                             Source code.
  test/                            Unit tests using JUnit.
```

## Repository Dependencies ##

Repository dependencies fall into two categories as indicated below.

### Repository Dependencies for this Repository ###

This library depends on other repositories listed in the following table.
The repository contains Eclipse configuration files that describe the dependencies so that
this repository and others can be cloned when setting up a development environment,
with minimal additional configuration (for example see TSTool Developer documentation).

|**Repository**|**Description**|
|----------------------------------------------------------------------------------------|----------------------------------------------------|
|[`cdss-lib-common-java`](https://github.com/OpenWaterFoundation/cdss-lib-common-java)   |Library of core utility code used by multiple repos.|

### Repositories that Depend on this Repository ###

The following repositories are known to depend on this repository:

|**Repository**|**Description**|
|----------------------------------------------------------------------------------------------------------------|----------------------------------------------------|
|[`cdss-app-statedmi-main`](https://github.com/OpenWaterFoundation/cdss-app-statedmi-main)                       |Main StateDMI application code.|
|[`cdss-app-tstool-main`](https://github.com/OpenWaterFoundation/cdss-app-tstool-main)                           |Main TSTool application code.|
|[`cdss-lib-processor-ts-java`](https://github.com/OpenWaterFoundation/cdss-lib-processor-ts-java)               |Library of processing code used by TSTool.|

## Development Environment Folder Structure ##

The following folder structure is recommended for software development.
Top-level folders should be created as necessary.
Repositories are expected to be on the same folder level to allow cross-referencing
scripts in those repositories to work.
TSTool is used as an example, and normally use of this repository will occur
through development of the main CDSS applications.
See the application's developer documentation for more information.

```
C:\Users\user\                               Windows user home folder (typical development environment).
/home/user/                                  Linux user home folder (not tested).
/cygdrive/C/Users/user                       Cygdrive home folder (not tested).
  cdss-dev/                                  Projects that are part of Colorado's Decision Support Systems.
    TSTool/                                  TSTool product folder (will be similar for other applications).
      eclipse-workspace/                     Folder for Eclipse workspace, which references Git repository folders.
                                             The workspace folder is not maintained in Git.
      git-repos/                             Git repositories for TSTool.
        cdss-lib-dmi-hydrobase-rest-java/    This repository.
        ...others...                         See application developer documenation and README for full list.

```

## Testing ##

OWF has set up two different methods of testing TSTool code. The software can be tested at a performance level through command files written to run and test different commands, or code can be tested at a low level to ensure functionality through several JUnit tests.

#### JUnit Testing: ####

JUnit is a unit testing framework that makes it possible to test small sections of code at a time. JUnit testing has been written to test [`ColoradoHydroBaseRestDataStore.java`](https://github.com/OpenWaterFoundation/cdss-lib-dmi-hydrobase-rest-java/blob/master/src/cdss/dmi/hydrobase/rest/ColoradoHydroBaseRestDataStore.java) and ensure proper functionality between the software and it's connection to DWR web wervices REST API.

The JUnit tests lie in [`ColoradoHydroBaseRestDataStoreTest.java`](https://github.com/OpenWaterFoundation/cdss-lib-dmi-hydrobase-rest-java/tree/master/test/cdss/dmi/hydrobase/rest). In this file there are two separate kinds of tests.

Some tests start with "testDeserializationOf..." These tests are designed to get a single result from DWR web services using a given method from `ColoradoHydroBaseRestDataStore`, and then compare this object to a hardcoded example of what the result is expected to look like. This tests that the conversion from web services' JSON response to POJO using Jackson is working properly.

Other tests start with "testLengthOf...". These tests are designed to check the length of the list returned from DWR web services. It has become apparent that some of these results from web services fluctuate consistently which causes these tests to fail. These tests may be removed in the future if they continue to fail whenever there is an update to DWR web services.

All of these tests produce output files that can be found in `test/results/` and can be compared to the output files created on the day the tests were written found in `tests/expectedResults/`.

#### Command File Testing: ####

Command files have been created that test the actual performance of TSTool and by implication the software behind it. These files test the results returned from certain commands and check that those results are as expected. These command files can be located in the repository [`cdss-app-tstool-test`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test).

There are tests for running TSID's found under [`test/regression/commands/general/TSID_ColoradoHydroBaseRest/`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test/tree/master/test/regression/commands/general/TSID_ColoradoHydroBaseRest). Some of these test Structure and Well types comparing results returned from ColoradoHydroBaseRest against results from Hydrobase database. Telemetry types are not possible to test against Hydrobase, so these test a single TSID command and make sure that it runs properly. There are some examples of tests that are expected to fail and these tests start with the comment `# @expectedStatus Warning`.

There are also tests found under [`test/regression/commands/general/ReadColoradoHydroBaseRest`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test/tree/master/test/regression/commands/general/ReadColoradoHydroBaseRest). These are a few simple command files to test that the command ReadColoradoHydroBaseRest() is working properly.

In both the folders specified above you can also find output files in `ExpectedResults/` and `Results/`. Expected Results contains files generated previously and offer as a way of checking re-run tests against old results.

##### Test Suites: ######

Also found in both the folder locations above will be a subfolder titled `TestSuites`. This folder contains two subfolders `create/` and `run/`. First run the command file found in `create/`, which will create another command file found in `run/`. The generated command file in `run/` will contain a list of commands to run every command file for either [`TSID_ColoradoHydroBaseRest/`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test/tree/master/test/regression/commands/general/TSID_ColoradoHydroBaseRest) or [`ReadColoradoHydroBaseRest/`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test/tree/master/test/regression/commands/general/ReadColoradoHydroBaseRest). This command file can be run to see if there are any errors or unforeseen warnings contained within any of the tests without having to run each test individually.

Read more about writing command files [here](http://learn.openwaterfoundation.org/cdss-app-tstool-doc-user/command-ref/overview/)

## Version ##

A version for the library is typically not defined.
Instead, tags are used to cross-reference the library version with commit of application code such as TSTool.
This allows checking out a version of the library consistent with an application version.
This approach might need to change if the library is seen as an independent resource that is used by many third-party applications.

## Contributing ##

Contributions to this project can be submitted using the following options:

1. Software developers with commit privileges can write to this repository
as per normal OpenCDSS development protocols.
2. Post an issue on GitHub with suggested change.  Provide information using the issue template.
3. Email a development contact.
4. Fork the repository, make changes, and do a pull request.
Contents of the current master branch should be merged with the fork to minimize
code review before committing the pull request.

See also the [OpenCDSS / protocols](http://learn.openwaterfoundation.org/cdss-website-opencdss/) for each software application.

## License ##

A license for the software is being determined as part of the OpenCDSS project.
GPL 3.0 has been recommended.

## Contact ##

See the [OpenCDSS information](http://learn.openwaterfoundation.org/cdss-website-opencdss) for overall contacts and contacts for each software product.
