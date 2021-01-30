# Spring REST. Part 2

The second part implements unit testing on Controller Layer using Mokito.

![Image](https://github.com/bbogdasha/java-online-marathon/blob/master/sprint19/Spring%20REST%20Lesson%20Two/screen/screen.jpg)

---

**1. GET: /students**

Lists all registered students with the courses they are enrolled in. Recurring courses have one id:

```json
[
    {
        "id": 1,
        "name": "Bobby",
        "surname": "Red",
        "courses": [
            {
                "id": 1,
                "name": "Java programming",
                "info": "The Java programming language was developed by Sun Microsystems in the early 1990s.",
                "steps": [
                    "Steps Steps",
                    "Steps Steps",
                    "Steps Steps"
                ]
            },
            {
                "id": 2,
                "name": "Cyber security",
                "info": "Cyber security is the practice of defending computers, servers, mobile devices, electronic systems, networks, and data from malicious attacks.",
                "steps": [
                    "Steps",
                    "Steps",
                    "Steps"
                ]
            }
        ]
    },
    {
        "id": 2,
        "name": "Emily",
        "surname": "White",
        "courses": []
    },
    {
        "id": 3,
        "name": "Tom",
        "surname": "Pink",
        "courses": [
            {
                "id": 3,
                "name": "Marketing",
                "info": "Marketing refers to activities a company undertakes to promote the buying or selling of a product, service, or good.",
                "steps": []
            },
            {
                "id": 1,
                "name": "Java programming",
                "info": "The Java programming language was developed by Sun Microsystems in the early 1990s.",
                "steps": [
                    "Steps Steps",
                    "Steps Steps",
                    "Steps Steps"
                ]
            }
        ]
    }
]
```

---

**2. GET: /courses**

List of all courses without repetitions:

```json
[
    {
        "id": 1,
        "name": "Java programming",
        "info": "The Java programming language was developed by Sun Microsystems in the early 1990s.",
        "steps": [
            "Steps Steps",
            "Steps Steps",
            "Steps Steps"
        ]
    },
    {
        "id": 2,
        "name": "Cyber security",
        "info": "Cyber security is the practice of defending computers, servers, mobile devices, electronic systems, networks, and data from malicious attacks.",
        "steps": [
            "Steps",
            "Steps",
            "Steps"
        ]
    },
    {
        "id": 3,
        "name": "Marketing",
        "info": "Marketing refers to activities a company undertakes to promote the buying or selling of a product, service, or good.",
        "steps": []
    }
]
```

---

**3. GET: /students/{studentId}**

Get information about the student and his courses by his ID, get student by id 3:

```json
{
    "id": 3,
    "name": "Tom",
    "surname": "Pink",
    "courses": [
        {
            "id": 3,
            "name": "Marketing",
            "info": "Marketing refers to activities a company undertakes to promote the buying or selling of a product, service, or good.",
            "steps": []
        },
        {
            "id": 1,
            "name": "Java programming",
            "info": "The Java programming language was developed by Sun Microsystems in the early 1990s.",
            "steps": [
                "Steps Steps",
                "Steps Steps",
                "Steps Steps"
            ]
        }
    ]
}
```

---

**3. GET: /students/{studentId}/courses**

Get information about student courses only, get student by 3 id:

```json
[
    {
        "id": 3,
        "name": "Marketing",
        "info": "Marketing refers to activities a company undertakes to promote the buying or selling of a product, service, or good.",
        "steps": []
    },
    {
        "id": 1,
        "name": "Java programming",
        "info": "The Java programming language was developed by Sun Microsystems in the early 1990s.",
        "steps": [
            "Steps Steps",
            "Steps Steps",
            "Steps Steps"
        ]
    }
]
```
---

**4. POST: /students/add**

**5. POST: /students/{studentId}/courses/add**

And the ability to add a student or course to a specific student by his ID, sends in the format JSON.

