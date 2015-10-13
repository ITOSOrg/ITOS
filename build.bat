@echo on

call SetEnv.cmd

If Not "%APP_BUILDFILE%" == "" goto doBuild
set APP_BUILDFILE=./bin/app_build.xml

:doBuild
ant -buildfile %APP_BUILDFILE% -Dprp.noninternedstrings=true %*
