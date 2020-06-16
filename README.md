# RetrofitAndroidDesugaring
When using the combination of retrofit and the new Android desugaring of java 8 API's i am facing the following exception:
`java.lang.TypeNotPresentException: Type java.time.Instant not present`

This only occures on android devices lower then Android API level 24. When its run on a devices of 24 or higher it isn't a problem.
