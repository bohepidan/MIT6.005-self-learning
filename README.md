# MIT 6.005 SUMMARY
- **[Lecture website](https://ocw.mit.edu/courses/6-005-software-construction-spring-2016/pages/readings/)**

## Reading 1 : Static Checking

## Reading 2 : Basic java
- [Java Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

## Reading 3 : Testing
- Test-first programming. Write tests before you write code.
- Partitioning and boundaries for choosing test cases systematically.
- White box testing and statement coverage for filling out a test suite.
- Unit-testing each module, in isolation as much as possible.
- Automated regression testing to keep bugs from coming back.

## Reading 4 : Code Review
- Don’t Repeat Yourself (DRY)
- Comments where needed
- Fail fast
- Avoid magic numbers
- One purpose for each variable
- Use good names
- No global variables
- Return results, don’t print them
- Use whitespace for readability

## Reading 5 : Version Control
- *How Git works and how to use it*
> Everything you need to know about Git is on the [Pro Git book](https://git-scm.com/book/zh/v2).

## Reading 6 : Specifications
- *An appropriately weak specification gives freedom to the implementor, and an appropriately strong specification gives freedom to the client.*
- [Java exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)

## Reading 7 : Designing Specifications
- *Three dimensions for comparing specs: deterministic, declarative, strong*
- *Package and Access Controll*
- *An appropriately weak specification gives freedom to the implementor, and an appropriately strong specification gives freedom to the client.*

## Reading 8 : Avoiding Debugging
- *Use assert in code implementation*
- *Modualrity & Encapsulation*
- Avoid debugging
  - make bugs impossible with techniques like static typing, automatic dynamic checking, and immutable types and references
- Keep bugs confined
  - failing fast with assertions keeps a bug’s effects from spreading
  - incremental development and unit testing confine bugs to your recent code
  - scope minimization reduces the amount of the program you have to search

## Reading 9 : Mutability & Immutability
- **Safe from bugs.** Immutable objects aren’t susceptible to bugs caused by aliasing. Immutable references always point to the same object.
- **Easy to understand.** Because an immutable object or reference always means the same thing, it’s simpler for a reader of the code to reason about — they don’t have to trace through all the code to find all the places where the object or reference might be changed, because it can’t be changed.
- **Ready for change.** If an object or reference can’t be changed at runtime, then code that depends on that object or reference won’t have to be revised when the program changes.

## Reading 10 : Recursion
- **Safe from bugs.** Recursive code is simpler and often uses immutable variables and immutable objects.

- **Easy to understand.** Recursive implementations for naturally recursive problems and recursive data are often shorter and easier to understand than iterative solutions.

- **Ready for change.** Recursive code is also naturally reentrant, which makes it safer from bugs and ready to use in more situations.

## Reading 11 : Debugging
- **Safe from bugs.** We’re trying to prevent them and get rid of them.
- **Easy to understand.** Techniques like static typing, final declarations, and assertions are additional documentation of the assumptions in your code. Variable scope minimization makes it easier for a reader to understand how the variable is used, because there’s less code to look at.
- **Ready for change.** Assertions and static typing document the assumptions in an automatically-checkable way, so that when a future programmer changes the code, accidental violations of those assumptions are detected.

## Reading 12 : Abstract Data Type
- Abstract data types are characterized by their operations.
- Operations can be classified into creators, producers, observers, and mutators.
- An ADT’s specification is its set of operations and their specs.
- A good ADT is simple, coherent, adequate, and representation-independent.
- An ADT is tested by generating tests for each of its operations, but using the creators, producers, mutators, and observers together in the same tests.

## Reading 13 : Abstraction Functions and Rep Invariants
- An invariant is a property that is always true of an ADT object instance, for the lifetime of the object.
- A good ADT preserves its own invariants. Invariants must be established by creators and producers, and preserved by observers and mutators.
- The rep invariant specifies legal values of the representation, and should be checked at runtime with checkRep() .
- The abstraction function maps a concrete representation to the abstract value it represents.
- Representation exposure threatens both representation independence and invariant preservation.

## Reading 14 : Interfaces
- **Safe from bugs.** An ADT is defined by its operations, and interfaces do just that. When clients use an interface type, static checking ensures that they only use methods defined by the interface. If the implementation class exposes other methods — or worse, has visible representation — the client can’t accidentally see or depend on them. When we have multiple implementations of a data type, interfaces provide static checking of the method signatures.
- **Easy to understand.** Clients and maintainers know exactly where to look for the specification of the ADT. Since the interface doesn’t contain instance fields or implementations of instance methods, it’s easier to keep details of the implementation out of the specifications.
- **Ready for change.** We can easily add new implementations of a type by adding classes that implement interface. If we avoid constructors in favor of static factory methods, clients will only see the interface. That means we can switch which implementation class clients are using without changing their code at all.
- **[Why Interfaces?](https://ocw.mit.edu/ans7870/6/6.005/s16/classes/14-interfaces/#why_interfaces)**

## Reading 15 : Equality
- **[How to override `Object.hashCode()`?](https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method-for-a-collection)**
- *Always add notion @Override to override methods.*
- *Can’t really use Integer interchangeably with int(e.g. == override).*
- Equality should be an equivalence relation (reflexive, symmetric, transitive).
- Equality and hash code must be consistent with each other, so that data structures that use hash tables (like `HashSet` and `HashMap` ) work properly.
- The abstraction function is the basis for equality in immutable data types.
- Reference equality is the basis for equality in mutable data types; this is the only way to ensure consistency over time and avoid breaking rep invariants of hash tables.

## Reading 16 : Recursive Data Types
- *Immutability is powerful not just because of its safety, but also because of the potential for sharing.*
- *Keep `null`s out of your data structures, and your life will be happier.*
- **Safe from bugs.** Recursive datatypes allow us to tackle problems with a recursive or unbounded structure. Implementing appropriate data structures that encapsulate important operations and maintain their own invariants is crucial for correctness.
- **Easy to understand.** Functions over recursive datatypes, specified in the abstract type and implemented in each concrete variant, organize the different behavior of the type.
- **Ready for change.** A recursive ADT, like any ADT, separates abstract values from concrete representations, making it possible to change low-level code and high-level structure of the implementation without changing clients.

## Reading 17 : Regular Expressions
- 3 important production expresstions : 
  - concatenation
  `x ::= y z      #an x is a y followed by a z`
  - repetition
  `x ::= y*       #an x is zero or more y`
  - union(alternation)
  `x ::= y | z    #an x is a y or a z`
- e.g. `http://didit.csail.mit.edu:4949/`
  The grammar is:
  ```url
  url ::= 'http://' hostname (':' port)? '/' 

  hostname ::= word '.' hostname | word '.' word

  port ::= [0-9]+

  word ::= [a-z]+
  ```
  Which is defined recursively and is not a regex.
  The parse tree is shown below:
  ![parse tree](/images/parse_tree.png)

## Reading 18 : Parser Generators
- **[reading page](https://ocw.mit.edu/ans7870/6/6.005/s16/classes/18-parser-generators/)**
- 可以使用`Antlr 4`来应对需要进行语法分析的场景
- Antlr 4能将输入的字符串流转化为语法树(parser tree)，通过对该语法树进行操作可以生成递归数据类型
- **Safe from bugs.** A grammar is a declarative specification for strings and streams, which can be implemented automatically by a parser generator. These specifications are often simpler, more direct, and less likely to be buggy then parsing code written by hand.

- **Easy to understand.** A grammar captures the shape of a sequence in a form that is compact and easier to understand than hand-written parsing code.

- **Ready for change.** A grammar can be easily edited, then run through a parser generator to regenerate the parsing code.

## Reading 19 : Concurrency
- printf和debug的运行时间是简单语句的几十上百倍，因此很多race condition会因为debug而“消失”，但实际完全没有解决问题
- Concurrency: multiple computations running simultaneously
- Shared-memory & message-passing paradigms
- Processes & threads
  - Process is like a virtual computer; thread is like a virtual processor
- Race conditions
  - When correctness of result (postconditions and invariants) depends on the relative timing of events