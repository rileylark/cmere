#!/bin/bash

cd CmereShared
ant
cd ..

mkdir -p CmereSharedJsBridge/lib
cp CmereShared/CmereShared.jar CmereSharedJsBridge/lib/CmereShared.jar

cd CmereSharedJsBridge
ant
cd ..

mkdir -p web/src/scripts/cmereSharedJsBridge
cp CmereSharedJsBridge/war/sharedjsbridge/sharedjsbridge.nocache.js web/src/scripts/cmereSharedJsBridge/sharedjsbridge.nocache.js

