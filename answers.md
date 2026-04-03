**REFLECTION:** Use the terms _“subtype”_, _“polymorphism”_ 
and _“dynamic method dispatch”_ to explain why `Main.run` 
works correctly for **ANY** of your `Logger` implementations.

**Answer**

Because `Main.run` uses the variable "logger" which is a `Logger` 
and can be instantiated as any of the created subtypes of `Logger` 
that the Appendix A describes and because this "logger" variable 
can be any of the subtypes, polymorphism comes into play when executing
`Main.run` it uses dynamic method dispatch to correctly determine 
which specific implementation of the `log` method to run according
to the instantiated subtype of "logger".

**REFLECTION:** Why can the `Logger.formatMessage` method 
have a default implementation? Why must the `Logger.log` 
method be abstract?

**Answer**

`Logger.formatMessage` is a default implementation because the format
of the final message of any logger is always the same regardless of the
implementation; therefore a default method saves lines of code for each
implementation. `Logger.log` must be an abstract method because it 
specifically defines the logic of each individual implementation - what 
makes them unique.

**REFLECTION:** Among all the `Loggers` you have implemented, 
**ONLY** `MemoryLogger` objects can be passed to the 
`Main.export` method. Why? Why **MUST** the declaration for 
the `MemoryLogger` use ‘MemoryLogger’ instead of just 
‘Logger’ as its type?
(Try changing the declaration line to ‘Logger’ and see what 
happens.)

**Answer**

Because the method `Main.export` receives an `Exportable` as its
first parameter which only `MemoryLogger` is part of, therefore 
it MUST be `MemoryLogger` since any other "logger" is NOT an
`Exportable`.