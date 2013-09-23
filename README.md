App Introduction
===================

App Introduction is a library that helps to create introduction menu for users. 

Only thing that you need to do is giving the id of the element to show (if you want to point an element) and
write the message. You can choose pointing type like vertical or horizontal. Then the rest is done by library.

The messages that you add to the same AppIntroduction object are stored and showed to the user one by one.
You can create listeners for beginning and after the steps so you can have full control on steps. Also you can
create a listener to know when user dismisses the AppIntroduction.

Features included
-----------------
* Showing the message in the middle.
* Showing the message with horizontal pointer.
* Showing the message with vertical pointer.

Screenshots
-----------

![Message in the middle][1].![Message with vertical pointer][2].![Message with horizontal pointer][3].![Message with vertical pointer again.][4]


 [1]: https://raw.github.com/eluleci/appintroduction/master/screenshots/1.png
 [2]: https://raw.github.com/eluleci/appintroduction/master/screenshots/2.png
 [3]: https://raw.github.com/eluleci/appintroduction/master/screenshots/3.png
 [4]: https://raw.github.com/eluleci/appintroduction/master/screenshots/4.png
 

## Usage

The first three step additions are the codes for the creation of the messages in the screenshots.

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
                
                
                
// constructing AppIntroduction for listening dismiss of the user
appIntroduction = new AppIntroduction(this) {
    @Override
    public void onDismiss() {
        super.onDismiss();
        // handle user's dismiss
    }
};              



// listeners for steps. you can do some changes before or after a step
appIntroduction.addStep(new Step(R.id.second_language,
        getResources().getString(R.string.uc_shuffle_11), AppIntroduction.SIDE_VERTICAL, new StepActionListener() {
    @Override
    public void beforeMessageShown() {
        listenModeSettings.setVisibility(View.VISIBLE);
    }

    @Override
    public void afterMessageShown() {
        listenModeSettings.setVisibility(View.GONE);
    }
}));

```

