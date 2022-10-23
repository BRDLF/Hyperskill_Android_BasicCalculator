# Hyperskill_Kotlin_BasicCalculator

### Stage 4/4: Finishing touches

Oki dokes, it's done. Pretty simple for the finishing touches. I'd actually already included a function to convert a string-double to a string-int. \
Using the hint to show history is a cute touch, I probably would have done something different but this is supposed to be a simple calculator, not an advanced one. \
This app doesn't have a layout for landscape mode. I think that's fine, but I'd really like to learn how to do that. Maybe the next project.

### Stage 3/4: Calculations

Right now this is very messy. I'm less concerned with making a "nice" or a "good" app and more "making something that works". \
So yeah, this is hardly a good calculator to use. I've yet to make it do, like, good math.
There were lots of niche expectations that the lesson required that weren't explicitly stated until the tests failed. Though others were simply "things I didn't realize/think about" \
If nothing else i'm glad to have made some kind of progress.

### Stage 2/4: Enter a number

Ok. This is more what i'm used to.
Though, my familiarity is still a bit shaky. I know how to make things work, but I'm not exactly sure They're working well.
The buttons are still misaligned, and if the editText field gets too large it starts to crows out the screen. I've got to find some way to fix that, but it's not a priority yet. \
Is this what they call "technical debt"? Perhaps.

### Stage 1/4: The layout

This is my first foray into Android dev work. The first hurdle is getting familiar with the ecosystem. How it all works.
So far, it seems really similar to HTML, just working on frontend. "Making things pretty" and so forth. \
I am really bad at it, turns out! \
Maybe that's wrong. Rather, I'm very inexperienced at it. Horizontally aligning these buttons is a hassle. The lessons from the course imply they want me to use nested LinearLayouts to form rows and then cells.
But when adding padding to the buttons, they become askew. The alternative is to use a GridLayout, but in order to use rowWeight/columnWeight, I need to set the minimumAPI to 21 and not 20 like required in the course.
I plan on becoming more familiar with the Constrained Layout and using constrainedRowWeight etc, but that will come in due time. For now it's a bit of an uneven ugly mess. I just want to put something out for right now.