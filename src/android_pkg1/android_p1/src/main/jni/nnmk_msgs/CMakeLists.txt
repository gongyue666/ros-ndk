cmake_minimum_required(VERSION 2.8.3)
find_package(catkin REQUIRED COMPONENTS
  message_generation
  geometry_msgs
  std_msgs)
add_message_files(FILES Marker.msg)

generate_messages(DEPENDENCIES std_msgs geometry_msgs)

catkin_package(
  CATKIN_DEPENDS
    message_runtime
    geometry_msgs
    std_msgs
)
