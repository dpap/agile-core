#!/usr/bin/env python3
#-------------------------------------------------------------------------------
# Copyright (C) 2017 Create-Net / FBK.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License 2.0
# which accompanies this distribution, and is available at
# https://www.eclipse.org/legal/epl-2.0/
# 
# Contributors:
#     Create-Net / FBK - initial API and implementation
#-------------------------------------------------------------------------------

# --- Imports -----------
import sys
import time
import dbus
# -----------------------

# DBus
DM_BUS_NAME = "iot.agile.DeviceManager"
DM_OBJ_PATH = "/iot/agile/DeviceManager"

# --- Main program ------
if __name__ == "__main__":

   global device_manager

   # DBus
   session_bus = dbus.SessionBus()
   dbusdm = session_bus.get_object(DM_BUS_NAME, DM_OBJ_PATH)
   device_manager = dbus.Interface(dbusdm, dbus_interface=DM_BUS_NAME)

   print (device_manager.Devices())
