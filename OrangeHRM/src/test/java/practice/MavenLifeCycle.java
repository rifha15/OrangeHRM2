package practice;
/*
 * Maven has clean Life Cycle and Build Life Cycle.
 * It also has Site Life Cycle (Not Important).
 * CLean Life Cycle --- 1) Pre-clean
 * 						2)Clean
 * 						3)Post-clean
 * Clean goal is to delete any previous build directories and reinstall them.
 * Build Life Cyle ---- There are 9 phases.
 * If we call the latest phase, it will include all the previous phases.
 * Phase 1 -- Validate: Check whether the project has all the information it needs.
 * Phase 2 -- Initialize: Basically it starts setting up the properties for the build state.
 * Phase 3 -- Compile: It gets all the source code and translates it.
 * Phase 4 -- Test Compile: It compiles the source code for the test.
 * Phase 5 -- Test : It runs the profiles that's given. If no profile is given, it will run all @Test.
 * Phase 6 -- Package: Once all the test case pass/success, it will create  a package.
 * Phase 7 -- Verify: It's going to run the last check-up for the package to see if its good.
 * Phase 8 -- Install: This is where exits create a package into your local repositories.
 * Phase 9 -- Deploy: It will now put in the remote repositories. 
*/

public class MavenLifeCycle {

}
