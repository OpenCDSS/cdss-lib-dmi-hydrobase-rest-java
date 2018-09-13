#### JUnit Testing: ####

JUnit is a unit testing framework that makes it possible to test small sections of code at a time. JUnit testing has been written to test [`ColoradoHydroBaseRestDataStore.java`](https://github.com/OpenWaterFoundation/cdss-lib-dmi-hydrobase-rest-java/blob/master/src/cdss/dmi/hydrobase/rest/ColoradoHydroBaseRestDataStore.java) and ensure proper functionality between the software and it's connection to DWR web wervices REST API.

The JUnit tests lie in [`ColoradoHydroBaseRestDataStoreTest.java`](https://github.com/OpenWaterFoundation/cdss-lib-dmi-hydrobase-rest-java/tree/master/test/cdss/dmi/hydrobase/rest). In this file there are two separate kinds of tests.

Some tests start with "testDeserializationOf..." These tests are designed to get a single result from DWR web services using a given method from `ColoradoHydroBaseRestDataStore`, and then compare this object to a hardcoded example of what the result is expected to look like. This tests that the conversion from web services' JSON response to POJO using Jackson is working properly.

Other tests start with "testLengthOf...". These tests are designed to check the length of the list returned from DWR web services. It has become apparent that some of these results from web services fluctuate consistently which causes these tests to fail. These tests may be removed in the future if they continue to fail whenever there is an update to DWR web services.

All of these tests produce output files that can be found in `test/results/` and can be compared to the output files created on the day the tests were written found in `tests/expectedResults/`.

#### Command File Testing: ####

Command files have been created that test the actual performance of TSTool and by implication the software behind it. These files test the results returned from certain commands and check that those results are as expected. These command files can be located in the repository [`cdss-app-tstool-test`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test).

Read more about Command File Tests [here](https://github.com/OpenWaterFoundation/cdss-app-tstool-test).

There are tests for running TSID's found under [`test/regression/commands/general/TSID_ColoradoHydroBaseRest/`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test/tree/master/test/regression/commands/general/TSID_ColoradoHydroBaseRest). Some of these test Structure and Well types comparing results returned from ColoradoHydroBaseRest against results from Hydrobase database. Telemetry types are not possible to test against Hydrobase, so these test a single TSID command and make sure that it runs properly. There are some examples of tests that are expected to fail and these tests start with the comment `# @expectedStatus Warning`.

There are also tests found under [`test/regression/commands/general/ReadColoradoHydroBaseRest`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test/tree/master/test/regression/commands/general/ReadColoradoHydroBaseRest). These are a few simple command files to test that the command ReadColoradoHydroBaseRest() is working properly.

In both the folders specified above you can also find output files in `ExpectedResults/` and `Results/`. Expected Results contains files generated previously and offer as a way of checking re-run tests against old results.

##### Test Suites: ######

Also found in both the folder locations above will be a subfolder titled `TestSuites`. This folder contains two subfolders `create/` and `run/`. First run the command file found in `create/`, which will create another command file found in `run/`. The generated command file in `run/` will contain a list of commands to run every command file for either [`TSID_ColoradoHydroBaseRest/`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test/tree/master/test/regression/commands/general/TSID_ColoradoHydroBaseRest) or [`ReadColoradoHydroBaseRest/`](https://github.com/OpenWaterFoundation/cdss-app-tstool-test/tree/master/test/regression/commands/general/ReadColoradoHydroBaseRest). This command file can be run to see if there are any errors or unforeseen warnings contained within any of the tests without having to run each test individually.

Read more about writing command files [here](http://learn.openwaterfoundation.org/cdss-app-tstool-doc-user/command-ref/overview/)
