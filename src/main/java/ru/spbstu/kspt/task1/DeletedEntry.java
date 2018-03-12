package ru.spbstu.kspt.task1;

class DeletedEntry extends HashCreate {
        private static DeletedEntry entry = null;

        private DeletedEntry() {
            super(-1, -1);
        }

        static DeletedEntry getUniqueDeletedEntry() {
            if (entry == null) {
                entry = new DeletedEntry();
            }
            return entry;
        }
}
