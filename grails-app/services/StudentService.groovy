import example.Student

// @Transactional
class StudentService {

    static transactional = true

    Student student

    def get(id){
        Student.get(id)
    }

    def list() {
        Student.list()
    }

    def save(student){
        student.save()
    }

    def delete(id){
        Student.get(id).delete()
    }
}