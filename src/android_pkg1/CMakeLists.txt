##############################################################################
# CMake
##############################################################################

cmake_minimum_required(VERSION 2.8.3)
project(android_pkg1)

##############################################################################
# Catkin
##############################################################################

find_package(catkin REQUIRED rosjava_build_tools)
# Set the gradle targets you want catkin's make to run by default
# e.g. usually catkin_android_setup(assembleRelease uploadArchives)
ADD_SUBDIRECTORY(android_p1/src/main/jni/nnmk_msgs)
catkin_android_setup(assembleDebug uploadArchives)


##############################################################################
# Installation
##############################################################################

# Deploy android libraries (.aar's) and applications (.apk's)
#install(DIRECTORY ${CATKIN_DEVEL_PREFIX}/${CATKIN_GLOBAL_MAVEN_DESTINATION}/com/github/rosjava/${PROJECT_NAME}/ 
#       DESTINATION ${CATKIN_GLOBAL_MAVEN_DESTINATION}/com/github/rosjava/${PROJECT_NAME}/)
