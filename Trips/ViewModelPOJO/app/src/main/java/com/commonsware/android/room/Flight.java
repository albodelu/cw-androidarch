/***
 Copyright (c) 2017 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain	a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS,	WITHOUT	WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.

 Covered in detail in the book _The Busy Coder's Guide to Android Development_
 https://commonsware.com/Android
 */

package com.commonsware.android.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.TypeConverters;
import java.util.Date;
import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(
  tableName="flights",
  foreignKeys=@ForeignKey(
    entity=Trip.class,
    parentColumns="id",
    childColumns="tripId",
    onDelete=CASCADE),
  indices=@Index("tripId"))
@TypeConverters({TypeTransmogrifier.class})
class Flight extends Plan {
  public final String departingAirport;
  public final String arrivingAirport;
  public final String airlineCode;
  public final String flightNumber;
  public final String seatNumber;
  public final String tripId;

  @Ignore
  Flight(String title, int duration, Priority priority, Date startTime,
         String departingAirport, String arrivingAirport, String airlineCode,
         String flightNumber, String seatNumber, String tripId) {
    super(title, duration, priority, startTime);
    this.departingAirport=departingAirport;
    this.arrivingAirport=arrivingAirport;
    this.airlineCode=airlineCode;
    this.flightNumber=flightNumber;
    this.seatNumber=seatNumber;
    this.tripId=tripId;
  }

  Flight(String id, String title, int duration,
         Priority priority, Date startTime, Date creationTime,
         Date updateTime, String departingAirport, String arrivingAirport,
         String airlineCode, String flightNumber, String seatNumber,
         String tripId) {
    super(id, title, duration, priority, startTime, creationTime, updateTime);
    this.departingAirport=departingAirport;
    this.arrivingAirport=arrivingAirport;
    this.airlineCode=airlineCode;
    this.flightNumber=flightNumber;
    this.seatNumber=seatNumber;
    this.tripId=tripId;
  }
}
