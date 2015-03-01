#!/bin/bash

cd CmereShared
ant
cd ..

mkdir -p CmereSharedJsBridge/lib
cp CmereShared/CmereShared.jar CmereSharedJsBridge/lib/CmereShared.jar

cd CmereSharedJsBridge
ant

