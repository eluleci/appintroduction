App Introduction
===================

App Introduction is a library that helps to create introduction menu for the users. 

Only thing that you need to do is giving the id of the element to show (if you want to point an element) and
write the message. You can choose pointing type like vertical or horizontal. Then the rest is done by library.

Features included
-----------------
* Showing the message in the middle.
* Showing the message with horizontal pointer.
* Showing the message with vertical pointer.

Screenshots
-----------

![Message in the middle][1].![Message with vertical pointer][2].![Message with horizontal pointer][3].![Message with vertical pointer again.][3]


 [1]: https://photos-1.dropbox.com/t/0/AACWBpoh1btyvSWpiw1PnB7arr3NJIaPEht1rTv8SE9i8A/12/73509957/png/1024x768/3/1379955600/0/2/1.png/zKxqyHz-eKQcbhYBor5uTrye-CMwIRK4YgRPMAsYVU0
 [2]: https://photos-3.dropbox.com/t/0/AABzE7-5hizcUjhHYVYwz5t3MIOffTveVFjrUYn13PNhaQ/12/73509957/png/1024x768/3/1379955600/0/2/2.png/bO8SeezFTwm6qEuTEtcdJcKX_cI_xtAurZWhpOqr7pY
 [3]: https://photos-3.dropbox.com/t/0/AABtlaKUBP7DdEX1C0tKNg1Rdwd2seDJNWVTmY7I_56zWQ/12/73509957/png/1024x768/3/1379955600/0/2/3.png/TgBSgOUUVE3J1JitKsdDTrGbae8dXzjlKmcblNgcjVg
 [4]: https://photos-3.dropbox.com/t/0/AACcjUhv-_ZgahyQFatmZCcRGOIgtH6pjH3m47RFVoTlSw/12/73509957/png/1024x768/3/1379955600/0/2/4.png/CpSUpbW9Onl_3Y0GyfxzpwZwg_NzjC0l269QfMBrm0k
 

## Usage

These are the codes for the creation of the messages in the screenshots.

```java

AppIntroduction appIntroduction = new AppIntroduction(this);

// adding message into middle
appIntroduction.addStep(new Step(getResources().getString(R.string.uc_main_1)));

// adding message with vertical pointer
appIntroduction.addStep(new Step(R.id.search,
                getResources().getString(R.string.uc_main_3), AppIntroduction.SIDE_VERTICAL));
                
// adding message with horizontal pointer
appIntroduction.addStep(new Step(R.id.next,
                getResources().getString(R.string.uc_shuffle_3), AppIntroduction.SIDE_HORIZONTAL));                

```

